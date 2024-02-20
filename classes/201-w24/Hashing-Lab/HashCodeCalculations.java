import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * In class lab for learning about hash code functions and collisions.
 * @author arafferty
 * @author vostinar
 * @author YOUR NAME HERE
 */
public class HashCodeCalculations {

    
    /**
     * A hashing function that uses the ASCII value of the first character of a string
     * @param s the string to hash
     * @return the hash code
     */
    public static int hashCode1(String s) {
        if(s.isEmpty()) {
            return 0;
        } else {
            return (int) s.charAt(0);
        }
    }
    
    /**
     * A hashing function that uses the sum of the ASCII values of the characters in a string.
     * @param s the string to hash
     * @return the hash code
     */
    public static int hashCode2(String s) {
        int hashCode = 0;
        for(int i = 0; i < s.length(); i++) {
            hashCode += (int) s.charAt(i);
        }
        return hashCode;
    }
    
    /**
     * A hashing function that uses the sum of the ASCII values of the characters in a string,
     * weighted by the position of the character in the string.
     * @param s the string to hash
     * @return the hash code
     */
    public static int hashCode3(String s) {
        int hashCode = 0;
        for(int i = 0; i < s.length(); i++) {
            hashCode = 129*hashCode + (int) s.charAt(i);
        }
        return hashCode;
    }
    
    /**
     * Compression function that takes a hash code (positive or negative) and
     * the number of buckets we have to use in our hash table, and compresses
     * the hash code into the range [0, numberOfBuckets).
     */
    public static int compressToSize(int hashCode, int numberOfBuckets) {
        int compressedValue = hashCode % numberOfBuckets;
        if(compressedValue >= 0) {
            return compressedValue;
        } else {
            return compressedValue + numberOfBuckets;//Mod of a negative number is negative - 
                                                     //map back to positive so in the range of 
                                                     //[0,numberOfBuckets)
        }
    }
    
    /**
     * Counts the number of buckets that have no words stored at them - i.e.,
     * they have value 0 - and calculates what proportion of the total buckets
     * that is.
     */
    public static double proportionOfBucketsWithNoWords(int[] buckets) {
        int emptyBucketCount = 0;
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] == 0) {
                emptyBucketCount++;
            }
        }
        return emptyBucketCount*1.0/buckets.length;
    }
    
    /**
     * Returns the maximum value in a single bucket
     */
    public static int getMaxBucketValue(int[] buckets) {
        int max = -1;//Safe starting value since all buckets[i] should be >= 0
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] > max) {
                max = buckets[i];
            }
        }
        return max;
    }
    
    /**
     * Returns the average number of words in each non-empty bucket
     */
    public static double getAverageInNonEmptyBuckets(int[] buckets) {
        int totalCount = 0;
        int totalNonEmpty = 0;
        for(int i = 0; i < buckets.length; i++) {
            totalCount += buckets[i];
            if(buckets[i] != 0) {
                totalNonEmpty++;
            }
        }
        return totalCount*1.0/totalNonEmpty;
    }
    
    
    /**
     * Calculates the number of words that would be placed in the same spot in a hash map.
     * @param numBuckets number of spots to include in the array
     * @param file file to read from
     * @param hashCodeFunctionToUse which of the hash functions to use; see lab 
     *                              description for more details
     * @return an array that indicates how many different words are place in index 0, 1, etc.
     */
    public static int[] collisionCounter(int numBuckets, String file, int hashCodeFunctionToUse) {
        int[] counts = new int[numBuckets];
        Set<String> seenWords = new HashSet<String>();
        try {
            Scanner scanner =  new Scanner(new File(file));
            while(scanner.hasNext()) {
                String word = scanner.next();
                if(!seenWords.contains(word)) {
                    int hashCode = 0;
                    switch(hashCodeFunctionToUse) {
                        case 1:
                            hashCode = hashCode1(word);
                            break;
                        case 2:
                            hashCode = hashCode2(word);
                            break;
                        case 3:
                            hashCode = hashCode3(word);
                            break;
                    }
                    counts[compressToSize(hashCode, numBuckets)]++;
                    seenWords.add(word);
                }  
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return counts;
    }
    
    
    /**
     * Prints out statistics about the number of words in the same
     * bucket for different hash code functions.
     * @param bucketSizes : each entry stores a number of buckets to consider
     *                      as the size of the hash table
     */
    public static void printCollisionInformation(int[] bucketSizes, String filename) {
        List<List<Double>>  statistics = new ArrayList<List<Double>>();
        for(int i = 0; i < bucketSizes.length; i++) {
            System.out.println("numBuckets = " + bucketSizes[i]);
            for(int j = 0; j <= 4; j++) {
                int[] counts = collisionCounter(bucketSizes[i], filename, j);
                List<Double> curStats = new ArrayList<Double>();
                curStats.add(getAverageInNonEmptyBuckets(counts));
                curStats.add((double) getMaxBucketValue(counts));
                curStats.add(proportionOfBucketsWithNoWords(counts));
                System.out.println("Hash function: " + j);

                System.out.println(curStats);
                System.out.println();
            }
            
        }
    }
    
    public static void main(String[] args) {
        //TODO: Change me!
        
    }
    
          
}
