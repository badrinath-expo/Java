import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Ep75_heapsProblems1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int kthSmallestElement(int arr[], int k) {
        int r = arr.length - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // step1:
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // step2
        for (int i = k; i <= r; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        int ans = pq.peek();
        return ans;
    }

    /********* problem 2 *******************/
    static int countNodes(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static boolean isCBT(Node root, int index, int cnt) {
        if (root == null) {
            return true;
        }

        if (index >= cnt) {
            return false;
        } else {
            boolean left = isCBT(root.left, 2 * index + 1, cnt); // 0 based indexing, call for childs
            boolean right = isCBT(root.right, 2 * index + 2, cnt);
            return left && right;
        }
    }

    static boolean isMaxOrder(Node root) {
        // leaf node
        if (root.left == null && root.right == null) {
            return true;
        }

        // only left node
        if (root.right == null) {
            return root.data > root.left.data;
        } else {
            boolean left = isMaxOrder(root.left);
            boolean right = isMaxOrder(root.right);
            return left && right && (root.data > root.left.data) && (root.data > root.right.data);
        }
    }

    // Heap, CBT, satisifes heap property
    static boolean isBinaryTreeHeap(Node root) {
        int index = 0;
        int totalCount = countNodes(root);
        return isCBT(root, index, totalCount) && isMaxOrder(root);
    } // T.C - O(N)

    /********* Merge 2 max heaps *****************/
    // Important - takes a node to its right place in a heap
    static void heapify(List<Integer> arr, int n, int i) {
        // In a CBT, leaf nodes exist at (n/2 + 1) to n index
        // we don't need to process for leaf nodes, we can only process for 0 --- n/2
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < n && arr.get(largest) < arr.get(left)) {
            largest = left;
        }

        if (right < n && arr.get(largest) < arr.get(right)) {
            largest = right;
        }

        if (largest != i) { // if largest is changes, then only
            // swap
            int temp = arr.get(largest);
            arr.set(largest, arr.get(i));
            arr.set(i, temp);

            heapify(arr, n, largest);
        }
    }

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            ans.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            ans.add(b[i]);
        }

        // step2: build heap using merged array
        int size = ans.size();
        for (int i = size / 2 - 1; i >= 0; i--) { // ignoring leaf nodes, since they don't form condition in heap
            heapify(ans, size, i);
        }

        int arr[] = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }


    /********** problem 4  ***********/
static long minCost(long[] arr, long n){
    PriorityQueue<Long> minHeap = new PriorityQueue<>();

    
    for (Long element : arr) {
        minHeap.add(element);
    }

    long cost = 0;

    while (minHeap.size() > 1) {
        long a = minHeap.peek();
        minHeap.remove();

        long b = minHeap.peek();
        minHeap.remove();

        long sum = a + b;
        cost +=sum;

        minHeap.add(sum);
    }

    return cost;
} // Dry run and understand why it works

/************* Problem 5 **************/
//Given BST is a complete Binary tree
//MinOrder property -> N < L, N<R  
static void cnvertBSTtoMinHeap(){
/* Given CBT, so structure won't change
 * Since it is BST,It has every node, N < L and  N < R,  Take inorder from the tree, we got a sorted elements.
 * Insert into the Bst, such that N < L < R. This NLR comes with preOrder. So, insert into the same BST with preorder traversal, then the tree becomes heap 
 */
}

    public static void main(String[] args) {

    }
}
