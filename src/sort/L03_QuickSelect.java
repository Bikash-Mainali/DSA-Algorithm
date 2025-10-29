package sort;

import java.util.Arrays;

public class L03_QuickSelect {

    public static int findKthLargest(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);

            // position of pivot in sorted ASC array
            int countFromEnd = arr.length - pivotIndex; // how many elements are >= pivot

            if (countFromEnd == k) {
                return arr[pivotIndex];
            } else if (countFromEnd > k) {
                return findKthLargest(arr, pivotIndex + 1, high, k);
            } else {
                return findKthLargest(arr, low, pivotIndex - 1, k);
            }
        }
        return -1;
    }

    // Partition so that numbers less than pivot are on the left,
    // and greater numbers are on the right (ascending order)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // choose first element as pivot
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            }
            while (arr[i] < pivot);

            do {
                j--;
            }
            while (arr[j] > pivot);

            if (i >= j)
                return j;

            swap(arr, i, j);
        }
    }



    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,8,5};
        int k = 2; // second largest
        int result = findKthLargest(arr, 0, arr.length - 1, k);
        System.out.println(k + "th largest element is: " + result);
        System.out.println("Array after partitioning: " + Arrays.toString(arr));
    }
}
