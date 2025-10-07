/**
 * In class lab for learning about hash code functions and collisions
 * Based on Java lab by Anna Rafferty
 * Translated to Kotlin and updated by Anya Vostinar
 */


class HashTable {
    var tableSize = 10
    //array of nulls to hold keys
    var keys: Array<String?> = arrayOfNulls<String>(tableSize)


    /**
     * A hashing function that uses the ASCII value of the first character of a string
     * @param s the string to hash
     * @return the hash code
     */
    fun hashCode1(s: String) : Int {
        //TODO
        return 0
    }

    /**
     * A hashing function that uses the sum of the ASCII values of the characters in a string.
     * @param s the string to hash
     * @return the hash code
     */
    fun hashCode2(s: String) : Int {
        //TODO
        return 0
    }

    /**
     * A hashing function that uses the sum of the ASCII values of the characters in a string,
     * weighted by the position of the character in the string.
     * @param s the string to hash
     * @return the hash code
     */
    fun hashCode3(s: String) : Int {
       //TODO
       return 0 
    }

    fun compressToSize(hashCode: Int) : Int {
        var compressedValue = hashCode % tableSize
        if(compressedValue >= 0) {
            return compressedValue
        } else {
            return compressedValue+tableSize
            //Mod of a negative number is negative - 
            //map back to positive so in the range of 
            //[0,numberOfBuckets)
        }
    }

    fun insertKey(str : String) {
        //TODO
    }

    override fun toString() : String {
        var returnString = ""
        for(key in keys) {
            returnString += key + " "
        }
        return returnString
    }

}

fun main() {
    var test = HashTable()
    println(test)

}