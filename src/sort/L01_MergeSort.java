package sort;

import java.util.Arrays;

public class L01_MergeSort {

    public static void mergeSort(int[] arr) {
        // Base case: if array has 1 element, it’s already sorted
        if (arr.length <= 1) {
            return;
        }

        // Split the array into two halves
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    // Merge two sorted arrays into original array
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Compare elements from left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right array
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Test the merge sort
    public static void main(String[] args) {
        int[] arr = {7,2,9,4,3,8,6,1};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("After sorting:  " + Arrays.toString(arr));
    }
}
