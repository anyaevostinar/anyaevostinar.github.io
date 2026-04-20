import kotlin.test.Test
import kotlin.test.assertEquals

class LanderTest {
    @Test
    fun testInitialization() {
        val lander = LunarLander(1000, 40, 25)
        assertEquals(1000, lander.altitude);
        assertEquals(40, lander.velocity);
        assertEquals(25, lander.fuel);

        val lander2 = LunarLander(1, 2, 3)
        assertEquals(1, lander2.altitude);
        assertEquals(2, lander2.velocity);
        assertEquals(3, lander2.fuel);

        val lander3 = LunarLander()
        assertEquals(1000, lander3.altitude);
        assertEquals(40, lander3.velocity);
        assertEquals(25, lander3.fuel);
    }

    @Test
    fun testBurn1() {
        val lander = LunarLander()
        lander.burn(1)
        assertEquals(38, lander.velocity)
        assertEquals(962, lander.altitude)
    }

    @Test
    fun testBurn2() {
        val lander = LunarLander()
        lander.burn(0)
        assertEquals(42, lander.velocity)
        assertEquals(958, lander.altitude)
    }

    @Test
    fun testBurn3() {
        val lander = LunarLander()
        lander.burn(5)
        assertEquals(20, lander.fuel)
        assertEquals(22, lander.velocity)
        assertEquals(978, lander.altitude)
    }

    @Test
    fun testBurn4() {
        val lander = LunarLander()
        lander.burn(1)
        lander.burn(4)
        assertEquals(20, lander.fuel)
        assertEquals(24, lander.velocity)
        assertEquals(938, lander.altitude)
    }

    @Test
    fun testStatus() {
        val lander = LunarLander()
        assertEquals("inflight", lander.status())
        lander.altitude = -3
        assertEquals("crashed", lander.status())
        lander.velocity = 2
        assertEquals("landed", lander.status())

    }


}
