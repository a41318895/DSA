package algorithm.sorting;

import java.util.Arrays;

/**
 * @author Aki Chou
 */
public class QuickSortingImpl {

    // Time Complexity : ( Best : O(n log n), Worst : O(n^2) ) 端看切割次數, 最好就是可以每次都切到中間值
    // Space Complexity : O(n) -- 沒有使用額外的陣列空間, 故每次遞迴都是O(1), 而遞迴呼叫最差n次
    // 處理大量資料時, 且不需要穩定排序之狀況
    public static void quickSort(int[] arr) {

        if(arr == null || arr.length == 0) return ;

        sort(arr, 0, arr.length - 1) ;
    }

    public static void sort(int[] arr, int arrayLeftBound, int arrayRightBound) {

        // Two pointers act as swapped point. LeftPointer also acts as temp leftBound, and rightPointer also temp rightBound.
        int leftPointer = arrayLeftBound ;
        int rightPointer = arrayRightBound ;

        int pivot = arr[leftPointer + (rightPointer - leftPointer) / 2] ;    // The middle of every part

        while(leftPointer < rightPointer) {

            // Find out the points should belong to left (right part but < pivot) / right (left part but > pivot) part.
            while (arr[leftPointer] < pivot) leftPointer ++ ;
            while (arr[rightPointer] > pivot) rightPointer -- ;

            if(leftPointer <= rightPointer) {

               commonSwap(arr, leftPointer, rightPointer) ;

               leftPointer ++ ;
               rightPointer -- ;
            }
        }

        if(arrayLeftBound < rightPointer) sort(arr, arrayLeftBound, rightPointer) ;    // Ensure have left part to sort
        if(leftPointer < arrayRightBound) sort(arr, leftPointer, arrayRightBound) ;    // Ensure have right part to sort
    }

    public static void commonSwap(int[] arr, int positionA, int positionB) {

        int temp = arr[positionA] ;
        arr[positionA] = arr[positionB] ;
        arr[positionB] = temp ;
    }

    public static void main(String[] args) {

        int[] testArray = {2, 1, 4, 3, 5, 8, 6, 7, 9, 0} ;      // Good init partition pivot (5) : near to middle value
        quickSort(testArray);
        System.out.println(Arrays.toString(testArray));


        int[] testArray2 = {4, 3, 7, 2, 9, 0, 1, 6, 8, 5} ;     // Bad init partition pivot (9) : near to max or min value
        quickSort(testArray2);
        System.out.println(Arrays.toString(testArray2)) ;
    }
}
