package algorithm.sorting;

import java.util.Arrays;

/**
 * @author Aki Chou
 */
public class MergeSortingImpl {

    // Time Complexity : O(n log n)
    // Space Complexity : O(n)
    // 處理大量資料時, 且需要穩定排序之狀況
    public static void mergeSort(int[] arr) {

        if(arr == null || arr.length <= 1) return ;     // At least two elements can merge

        // Init two parts size
        int middle = arr.length / 2 ;
        int[] left = new int[middle] ;
        int[] right = new int[arr.length - middle] ;

        // Make two parts array
        for(int i = 0 ; i < middle ; i ++) {
            left[i] = arr[i] ;
        }
        for(int i = middle ; i < arr.length ; i ++) {
            right[i - middle] = arr[i] ;
        }

        mergeSort(left) ;   // Finish the sort and merge of left part of original arr.
        mergeSort(right) ;  // Finish the sort and merge of right part of original arr.

        merge(arr, left, right) ;
    }

    public static void mergeSortUseArrayCopy(int[] arr) {

        if(arr == null || arr.length <= 1) return ;

        // Init two parts size
        int middle = arr.length / 2 ;
        int[] left = new int[middle] ;
        int[] right = new int[arr.length - middle] ;

        // Make two parts array (changed)
        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0, arr.length - middle);

        mergeSort(left) ;
        mergeSort(right) ;

        merge(arr, left, right) ;
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {

        int arrPointer = 0,  leftArrPointer = 0,  rightArrPointer = 0 ;

        // When left array and right array both have element in it.
        while(leftArrPointer < leftArr.length && rightArrPointer < rightArr.length) {

            // Sorting & Merging
            if(leftArr[leftArrPointer] < rightArr[rightArrPointer]) {
                arr[arrPointer ++] = leftArr[leftArrPointer ++] ;
            } else {
                arr[arrPointer ++] = rightArr[rightArrPointer ++] ;
            }
        }

        // Handle the situation : leftArr or rightArr has 'an' element is not merged & sorted.
        while(leftArrPointer < leftArr.length) arr[arrPointer ++] = leftArr[leftArrPointer ++] ;
        while(rightArrPointer < rightArr.length) arr[arrPointer ++] = rightArr[rightArrPointer ++] ;
    }

    // 陣列大小越大, 使用System.arrayCopy() 方法的 mergeSortUseArrayCopy() 會與 mergeSort() 的運行時間差距更顯著。
    public static void main(String[] args) {

        long startTime = System.nanoTime() ;

        int[] testArray = {3, 1, 4, 1, 5, 9, 2, 6} ;
        mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));

        long endTime = System.nanoTime() - startTime ;
        System.out.println(endTime + " nanoseconds.");



        long startTime2 = System.nanoTime() ;

        int[] testArray2 = {3, 1, 4, 1, 5, 9, 2, 6} ;
        mergeSortUseArrayCopy(testArray2);
        System.out.println(Arrays.toString(testArray2));

        long endTime2 = System.nanoTime() - startTime2 ;
        System.out.println(endTime2 + " nanoseconds.");
    }
}
