
import LinkedUnorderedList

class DNAStrand() : LinkedUnorderedList<Char>() {

    fun addSequence(sequence: List<Char>) {
        for (base in sequence.reversed()) {
            addFirst(base)
        }
    }

    override fun addFirst(item: Char) {
        if (item != 'A' && item != 'C' && item != 'G' && item != 'T') {
            throw IllegalArgumentException("Invalid DNA base: $item")
        }
        super.addFirst(item)
    }
    
    /**
    * Input: A node in the DNA strand to start the match at and a list of characters to check for a match
    * Output: Null if no match, otherwise the node past the end of the matching sequence in the linked list
    */
    fun matchesTemplate(current: Node<Char>?, template: List<Char>): Node<Char>? {
        //TODO
        return null
    }

    /**
     * Finds the first occurrence of [mutation] and removes it from the strand.
     * Reconnects the preceding nucleotide to the one following the mutation.
     */
    fun snipMutation(mutation: List<Char>) {
        //TODO
    }

}

fun main() {
    val strand = DNAStrand()
    strand.addSequence(listOf('A', 'C', 'G', 'T'))
    println("${strand}") 
    //val endNode = strand.matchesTemplate(strand.getNode(0), listOf('A', 'C')) 
    //println("Node past the end of matching template in the strand (should be G): ${endNode?.data}")

    //val mutation = listOf('C', 'G')
    //strand.snipMutation(mutation)
    //println("${strand}") 

    //val secondStrand = DNAStrand()
    //secondStrand.addSequence(listOf('A', 'C', 'G', 'T', 'A', 'C', 'G', 'T'))
    //secondStrand.snipMutation(mutation)
    //println("${secondStrand}") 

}