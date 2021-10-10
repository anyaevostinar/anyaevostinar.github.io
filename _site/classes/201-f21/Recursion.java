public class Recursion {
    /**
     * Merges the adjacent subarrays array[first..mid] and array[mid + 1..last].
     * Does not return anything, changes the values of array itself. 
     * Based on Carrano and Henry's algorithm.
     * @param array the array holding the subarrays to be merged
     * @param temp the array to temporarily place items into
     * @param first the first item in the first subarray
     * @param mid the last item in the first subarray
     * @param last the last item in the last subarray
     */
    public static void merge(int[] array, int[] temp, int first, int mid, int last) {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid +1;
        int endHalf2 = last;

        int index = first; // Next available location in tempArray
        // While both subarrays are not empty, compare an entry in one subarray with
        // an entry in the other; then copy the smaller item into the temporary array
        while((beginHalf1 <= endHalf1) && (beginHalf2<=endHalf2)) {
            if (array[beginHalf1] <= array[beginHalf2]) {
                //Place the smaller item in the temp array
                temp[index] = array[beginHalf1];
                beginHalf1++;
            } else {
                temp[index] = array[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        
        //One of the subarrays is now empty, so the rest of the items in the
        // other subarray should go into temp
        int restOfBegin;
        int restOfEnd;
        if(beginHalf1 > endHalf1) {
            restOfBegin = beginHalf2;
            restOfEnd = endHalf2;
        } else {
            restOfBegin = beginHalf1;
            restOfEnd = endHalf1;
        }
       
        //Place the rest of the items from the non-empty subarray into temp    
        while(restOfBegin<=restOfEnd) {
            temp[index] = array[restOfBegin];
            restOfBegin++;
            index++;
        }

        //Copy everything from temp back into array a
        for(int i=first; i<=last; i++){
            array[i] = temp[i];
        }   
    }
}