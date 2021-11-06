public class HashTable {

    private Integer[] hashTable;
  
    /**
    * Compression function that takes a hash code (positive or negative)  and compresses
    * the hash code into the range [0, sizeOfhashTable).
    */
    private int compressToSize(int hashCode) {
      int numberOfBuckets = hashTable.length;
      int compressedValue = hashCode % numberOfBuckets;
      if(compressedValue >= 0) {
        return compressedValue;
      } else {
        return compressedValue+numberOfBuckets;
      }
    }
  
    public static void main(String[] args) {
      
    }
  }