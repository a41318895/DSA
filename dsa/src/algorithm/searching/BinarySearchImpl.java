package algorithm.searching;

/**
 * @author Aki Chou
 */
public class BinarySearchImpl {

    public static int binarySearch(int[] arr, int target) {

        int leftPointer = 0, rightPointer = arr.length - 1 ;     // Define two pointer

        while(leftPointer <= rightPointer) {

            int middle = leftPointer + (rightPointer - leftPointer) / 2 ;   // Avoid crossing the max val of int (2^31 - 1)

            if(arr[middle] == target) return middle ;

            if(arr[middle] < target) leftPointer = middle + 1 ;
            else rightPointer = middle - 1 ;
        }

        return - 1 ;
    }

    public static void main(String[] args) {

        int[] testArray = {1,2,3,4,5,6,7,8,9,10} ;
        int target = 6 ;
        System.out.println(binarySearch(testArray, target));


        int[] testArray2 = {1,2,3,4,5} ;
        int target2 = 9 ;
        System.out.println(binarySearch(testArray2, target2));
    }
}
