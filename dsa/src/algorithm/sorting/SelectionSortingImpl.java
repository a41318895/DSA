package algorithm.sorting;

import java.util.Arrays;

/**
 * @author Aki Chou
 */
public class SelectionSortingImpl {

    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    // Bad Performance. Almost not be used
    public static int[] selectionSortAsc(int[] arr) {

        for(int unsortedHead = 0 ; unsortedHead < arr.length - 1 ; unsortedHead ++) {

            int tempMinIndex = unsortedHead ;

            for(int comparedIndex = unsortedHead + 1 ; comparedIndex < arr.length ; comparedIndex ++) {

                if(arr[tempMinIndex] > arr[comparedIndex]) tempMinIndex = comparedIndex ;
            }

            commonSwap(arr, tempMinIndex, unsortedHead);    // Swap unsortedHead and the minElementIndex in whole arr
        }

        return arr ;
    }

    public static int[] selectionSortDesc(int[] arr) {

        for(int unsortedHead = 0 ; unsortedHead < arr.length - 1 ; unsortedHead ++) {

            int tempMaxIndex = unsortedHead ;

            for(int comparedIndex = unsortedHead + 1 ; comparedIndex < arr.length ; comparedIndex ++) {

                if(arr[tempMaxIndex] < arr[comparedIndex]) tempMaxIndex = comparedIndex ;
            }

            commonSwap(arr, tempMaxIndex, unsortedHead);    // Swap unsortedHead and the maxElementIndex in whole arr
        }

        return arr ;
    }

    public static void commonSwap(int[] arr, int positionA, int positionB) {

        int temp = arr[positionA] ;
        arr[positionA] = arr[positionB] ;
        arr[positionB] = temp ;
    }

    public static void main(String[] args) {

        int[] testArray = {2, 1, 4, 3, 5, 7, 6} ;
        System.out.println(Arrays.toString(selectionSortAsc(testArray)));
        System.out.println(Arrays.toString(selectionSortDesc(testArray)));
    }
}
