package LeetcodeEasy.heap;

import java.util.Arrays;

/**
 * TC = Insert the new element at the end → O(1) + Restore the heap property by “bubbling up” (heapify) → log(n) = log(n)
 * <p>
 * <p>
 * parent node= i-1 / 2
 * left child node= 2i +1
 * right child node= 2i + 2
 */

public class HeapUsingArray {

    int heapSize;
    int[] heapArr;
    int index = -1;

    HeapUsingArray(int heapSize) {
        this.heapSize = heapSize;
        heapArr = new int[heapSize];
    }

    //insert into heap using array
    void insert(int data) {
        heapArr[++index] = data; //[40]
        heapifyUpIterative(heapArr, index);
        heapifyUpRecursion(heapArr, index);
    }

    //delete from heap (poll from top/root)
    void delete() {
        //Remove root and move lowermost data to the root
        int lastIndex = index;
        heapArr[0] = heapArr[lastIndex];
        heapArr[lastIndex] = 0;

        //heapify
        heapifyDownRecursion(0);
    }

    void heapifyUpRecursion(int[] arr, int childIndex) {
        if (childIndex == 0) { //when reaches root node during heapify
            return;
        }

        int parentIndex = (childIndex - 1) / 2;
        int parent = arr[parentIndex];
        int child = arr[childIndex];

        if (parent < child) {
            swap(parentIndex, childIndex);
            //max-heapify
            heapifyUpRecursion(arr, parentIndex);
        }
    }

    void heapifyDownRecursion(int parentIndex) {
        int largest = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        if (leftChild <= index && heapArr[leftChild] > heapArr[largest])
            largest = leftChild;

        if (rightChild <= index && heapArr[rightChild] > heapArr[largest])
            largest = rightChild;

        if (largest != parentIndex) {
            swap(parentIndex, largest);
            heapifyDownRecursion(largest);
        }
    }

    void heapifyUpIterative(int[] arr, int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (arr[parentIndex] < arr[childIndex]) {
                swap(parentIndex, childIndex);
                childIndex = parentIndex; // move up
            } else {
                break;
            }
        }
    }

    void swap(int parentIndex, int childIndex) {
        int temp = heapArr[parentIndex];
        heapArr[parentIndex] = heapArr[childIndex];
        heapArr[childIndex] = temp;
    }

    void printHeap() {
        int[] validHeap = Arrays.copyOfRange(heapArr, 0, index + 1);
        System.out.println(Arrays.toString(validHeap));
    }

    public static void main(String[] args) {
        HeapUsingArray heap = new HeapUsingArray(15);

        //insert
        heap.insert(40);
        heap.insert(10);
        heap.insert(30);
        heap.insert(50);
        heap.insert(20);

        int[] originalArray = Arrays.copyOfRange(heap.heapArr, 0, heap.index + 1);

        System.out.println("Heap array after insertion");
        heap.printHeap(); //50, 40, 30, 10, 20


        //delete
        heap.delete();
        System.out.println("Heap array after deletion");
        heap.printHeap();

    }
}
