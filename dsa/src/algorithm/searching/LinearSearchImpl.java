package algorithm.searching;

/**
 * @author Aki Chou
 */
public class LinearSearchImpl {

    // It is applicable to un-sorted array to find the index of indicated target.
    // Time Complexity: O(n), n is according to the len of arr.
    public static int linearSearch(int[] arr, int target) {

        for(int i = 0 ; i < arr.length ; i ++) {

            if(arr[i] == target) return i ;
        }

        return -1 ;     // Not Found
    }

    public static void main(String[] args) {

        int[] testIntArray = {3, 7, 1, 5, 9, 3} ;
        int target = 7 ;
        System.out.println(linearSearch(testIntArray, target));

        int[] testIntArray2 = {6, 2, 0, 1, 3, 7, 1} ;
        int target2 = 9 ;
        System.out.println(linearSearch(testIntArray2, target2));
    }
}
