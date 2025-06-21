import java.util.Collections;
import java.util.PriorityQueue;

public class Ep74_Heaps {

    static class Heap {
        int arr[] = new int[100];
        int size = 0;

        Heap() {
            arr[0] = -1;
            size = 0;
        }

        // Instert at end and take it to the correct position
        void insert(int val) {
            size = size + 1;
            int index = size;
            arr[index] = val;

            while (index > 1) {
                int parent = index / 2;

                if (arr[parent] < arr[index]) {
                    // swap
                    int temp = arr[parent];
                    arr[parent] = arr[index];
                    arr[index] = temp;

                    index = parent;
                } else {
                    return;
                }
            }
        } // O(logn)

        // swap first node with the last node
        void delete() {
            if (size == 0) {
                System.out.println("nothing to delete");
                return;
            }

            // step1: put last element into first index
            arr[1] = arr[size];
            // step2: remove last element
            size--;

            // take root node to its correct position
            int i = 1;
            while (i < size) {
                int leftIndex = 2 * i;
                int rightIndex = 2 * i + 1;

                if (leftIndex <= size && arr[i] <= arr[leftIndex]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[leftIndex];
                    arr[leftIndex] = temp;

                    i = leftIndex;
                } else if (rightIndex <= size && arr[i] <= arr[rightIndex]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[rightIndex];
                    arr[rightIndex] = temp;

                    i = rightIndex;
                } else {
                    return;
                }
            }
        }

        void print() {
            for (int i = 1; i <= size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Important - takes a node to its right place in a heap
    static void heapify(int arr[], int n, int i) {
        // In a CBT, leaf nodes exist at (n/2 + 1) to n index
        // we don't need to process for leaf nodes, we can only process for 0 --- n/2
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= n && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right <= n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) { // if largest is changes, then only
            // swap
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    } // O(logn)

    static void heapSort(int arr[], int n) {
        /*
         * step1: swap last index with first index, size--, place first index at right
         * place(heapify)
         */

        int size = n;

        while (size > 1) {
            // step1: swap
            int temp = arr[size];
            arr[size] = arr[1];
            arr[1] = temp;
            // step2
            size--;

            heapify(arr, size, 1);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);

        h.print(); // 55 54 53 50 52
        h.delete();
        h.print(); // 54 52 53 50

        /* heap creation & heapsort */
        int arr[] = { -1, 54, 53, 55, 52, 50 };
        int n = arr.length - 1;
        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        } // O(n) Home work how O(N)?

        System.out.println("printing the array now");

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("heap sort: ");

        heapSort(arr, n);

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Collection framework
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap

        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);

        System.out.println(minHeap.peek());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(1);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // prints in descending order: 20, 10, 5, 1
        }
    }
}

// Notes:
/*
 * Binary Tree: A tree with every node has chilren at most 2
 * Complete Binary Tree: Every level is completely filled, except the last
 * level, Nodes always filled towards the left.
 * Heap is a complete binary tree that comes with a heap order property
 * 
 * Max Heap:
 * Every child node is less than the parent node, maximum value stores at the
 * root
 * 
 * Min Heap:
 * Every child node is greater than the parent node, minimum value stores at the
 * root
 */

/*
 * 
 * Max Heap:
 * Let Node at ith index,
 * left child at 2*i index
 * Right child at 2*i+1,
 * parent = i/2;
 * 
 * 
 * Instert at end and take it to the correct position
 */

/*
 * Solve Min heap problem
 * 
 */