package algorithm.sorting;

import java.util.Arrays;

/**
 * @author Aki Chou
 */
public class InsertionSortingImpl {

    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    // 適用於數據量小時, 有 good performance
    public static int[] insertionSortAsc(int[] arr) {

        for(int repeatTime = 0 ; repeatTime < arr.length - 1 ; repeatTime ++) {
            for(int insertingTargetIndex = repeatTime + 1 ; insertingTargetIndex > 0 ; insertingTargetIndex --) {

                // Check from insertingTargetIndex to index : 0.
                if(arr[insertingTargetIndex - 1] > arr[insertingTargetIndex]) {
                    commonSwap(arr, insertingTargetIndex - 1, insertingTargetIndex) ;
                }
            }
        }

        return arr ;
    }

    public static int[] insertionSortDesc(int[] arr) {

        for(int repeatTime = 0 ; repeatTime < arr.length - 1 ; repeatTime ++) {
            for(int insertingTargetIndex = repeatTime + 1 ; insertingTargetIndex > 0 ; insertingTargetIndex --) {

                // Check from insertingTargetIndex to index : 0.
                if(arr[insertingTargetIndex - 1] < arr[insertingTargetIndex]) {
                    commonSwap(arr, insertingTargetIndex - 1, insertingTargetIndex) ;
                }
            }
        }

        return arr ;
    }

    public static void commonSwap(int[] arr, int positionA, int positionB) {

        int temp = arr[positionA] ;
        arr[positionA] = arr[positionB] ;
        arr[positionB] = temp ;
    }

    public static void main(String[] args) {

        int[] testArray = {-5, 2, -3, 1, 5, 4} ;

        System.out.println(Arrays.toString(insertionSortAsc(testArray)));
        System.out.println(Arrays.toString(insertionSortDesc(testArray)));
    }
}
