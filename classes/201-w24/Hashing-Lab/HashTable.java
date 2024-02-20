/**
 * A hash table starter class to be used in the Hashing lab.
 * @author Anya Vostinar
 */
public class HashTable {
  
    private Integer[] hashTable;

    /**
     * Constructor for the hash table
     * @param size the size of the hash table
     */
    public HashTable(int size) {
      hashTable = new Integer[size];
    }
  
    /**
    * Compression function that takes a hash code (positive or negative)  and compresses
    * the hash code into the range [0, sizeOfhashTable).
    * @param hashCode the hash code
    * @return the compressed value
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

    /**
     * Creates string representation of the hash table
     * @return string 
     */
    public String toString(){
      String returnString = "";
      for(int i = 0; i<hashTable.length; i++){
          returnString += hashTable[i] + " ";
      }
      return returnString;
  }

  /** 
   * Simple insertion method that ignores what is already there and just 
   * inserts the key into the hash table
   * @param key the key to insert
   */
  public void insertKey(Integer key) {
    int pos = compressToSize(key);
    hashTable[pos] = key;
  }
  
    public static void main(String[] args) {
      HashTable table = new HashTable(10);
      table.insertKey(56);
      System.out.println(table);
      
    }
  }