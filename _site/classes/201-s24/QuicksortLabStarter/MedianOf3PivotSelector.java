/**
 * @author Anya Vostinar
 * Note this isn't a particularly elegant implementation and instead
 * focuses on being clear and easy to understand.
 */
public class MedianOf3PivotSelector implements PivotSelector {

    /**
     * Chooses the pivot index as the median of the first, middle, and last elements of the array.
     * @param array the overall array being sorted
     * @param first the index of the first element of the subarray being sorted
     * @param last the index of the last element of the subarray being sorted
     * @return the index of the median of the first, middle, and last elements of the array
     */
    public int choosePivotIndex(int[] array, int first, int last) {
        int middle = (first + last) / 2;
        if (array[first] > array[middle]) {
            if (array[middle] > array[last]) {
                // last, middle, first
                return middle;
            } else if (array[first] > array[last]) {
                // middle, last, first
                return last;
            } else {
                // last, first, middle
                return first;
            }
        } else {
            // array[first] <= array[middle]
            if (array[first] > array[last]) {
                //last, first, middle
                return first;
            } else if (array[middle] > array[last]) {
                // first, last, middle
                return last;
            } else {
                // first, middle, last
                return middle;
            }
        }
    }
}