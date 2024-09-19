package algorithm.sorting;

import java.util.Arrays;

/**
 * @author Aki Chou
 */
public class BubbleSortingImpl {

    // Time Complexity : O(n^2)
    // Space Complexity : O(1)
    // Bad Performance. Almost not be used
    public static int[] bubbleSortAsc(int[] arr) {

        for(int repeatTime = 0 ; repeatTime < arr.length - 1 ; repeatTime ++) {
            for(int swapTime = 0 ; swapTime < arr.length - 1 - repeatTime ; swapTime ++) {

                // If arr[index + 1] is bigger than or equals arr[index] (Ascend), no need to swap.
                if(arr[swapTime] > arr[swapTime + 1]) commonSwap(arr, swapTime, swapTime + 1);
            }
        }

        return arr ;
    }

    public static int[] bubbleSortDesc(int[] arr) {

        for(int repeatTime = 0 ; repeatTime < arr.length - 1 ; repeatTime ++) {
            for(int swapTime = 0 ; swapTime < arr.length - 1 - repeatTime ; swapTime ++) {

                // If arr[index] is bigger than or equals arr[index + 1] (Descend), no need to swap.
                if(arr[swapTime + 1] > arr[swapTime]) commonSwap(arr, swapTime + 1, swapTime);
            }
        }

        return arr ;
    }

    public static void commonSwap(int[] arr, int positionA, int positionsB) {

        int temp = arr[positionA] ;
        arr[positionA] = arr[positionsB] ;
        arr[positionsB] = temp ;
    }

    public static void main(String[] args) {

        int[] testArray = {2, 3, 2, 5, 1, 6, 4, 3} ;

        System.out.println(Arrays.toString(bubbleSortAsc(testArray)));
        System.out.println(Arrays.toString(bubbleSortDesc(testArray)));
    }
}
