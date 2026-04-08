import Node
import LinkedUnorderedList

class CyclicLinkedList<T>(sequence: List<T>? = null) : LinkedUnorderedList<T>(sequence)  {

    // Handles printing potentially cyclic lists.
    override fun toString(): String {
        val cycleNode = findCycle()
        var current: Node<T>? = head
        var result = "head-> "
        var seenCycleNodeCount = 0
        while (current != null) {
            result = result + "["+current.data.toString() + "|-]-> "
            if (current == cycleNode) {
                if (seenCycleNodeCount < 3) {
                    seenCycleNodeCount++
                } else {
                    break
                }
            }
            current = current.next
        }
        return result
    }

    // Returns a node within the cycle (not necessarily the start of the cycle), or null if there is no cycle.
    fun findCycle(): Node<T>? {
        // TODO
        return null
    }
}

fun main() {
    println("\n---- Testing CyclicLinkedList ---")
    val list = CyclicLinkedList<Int>(mutableListOf(1, 2, 3))
    println("Non-cyclic list ($list)\n has cycle: ${list.findCycle() != null}") // should be false
    println(list)

    // create a cycle for testing
    list.getNode(2)?.next = list.getNode(0)
    println("Cyclic list ($list) \n has cycle: ${list.findCycle() != null}") // should be true


    println("\n\n --- Analyzing Money Trail 1 ---")
    val trail1 = generateTrail1()
    println("Suspicious activity: $trail1")
    val cycleNode1 = trail1.findCycle()
    if (cycleNode1 != null) {
        println("ALARM: Circular money flow detected! This is a round-trip scheme and ${cycleNode1.data} is involved!")
    } else {
        println("All clear: Money reached a dead end.")
    }

    println("\n\n --- Analyzing Money Trail 2 ---")
    val cycleList = generateTrail2()
    println("Suspicious activity: $cycleList")
    val cycleNode = cycleList.findCycle()
    if (cycleNode != null) {
        println("ALARM: Circular money flow detected! This is a round-trip scheme and ${cycleNode.data} is involved!")
    } else {
        println("All clear: Money reached a dead end.")
    }
}

fun generateTrail1(): CyclicLinkedList<String> {
    val trail = CyclicLinkedList<String>(mutableListOf(
        "Customer Account",
        "Online Payment Gateway",
        "Shipping Logistics Co",
        "Electronics Retailer",
        "Manufacturer Bank Account"
        ))

    return trail
}

fun generateTrail2(): CyclicLinkedList<String> {
    val trail = CyclicLinkedList<String>(mutableListOf(
        "Source",
        "Small Cash Business",
        "Consultant A",
        "Company B",
        "Offshore Account C"
    ))

    val tail = trail.getNode(4)
    val entryNode = trail.getNode(2)
    tail?.next = entryNode

    return trail
}