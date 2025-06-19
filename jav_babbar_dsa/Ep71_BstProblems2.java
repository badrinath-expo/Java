import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Ep71_BstProblems2 {
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

    static void inOrder(Node root, ArrayList<Integer> in) {
        if (root == null) {
            return;
        }

        inOrder(root.left, in);
        in.add(root.data);
        inOrder(root.right, in);
    }

    // find sum of any 2 nodes == target ,Does this pair exists
    static boolean twoSum(Node root, int target) {
        ArrayList<Integer> in = new ArrayList<Integer>();

        inOrder(root, in);

        int i = 0, j = in.size() - 1;

        while (i < j) {
            int sum = in.get(i) + in.get(j);

            if (sum == target) {
                return true;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    // Flatten BST to a sorted LL
    static Node flattenBST(Node root) {
        ArrayList<Integer> in = new ArrayList<Integer>();
        inOrder(root, in);
        int n = in.size();

        Node newRoot = new Node(in.get(0));

        Node curr = newRoot;

        for (int i = 1; i < in.length; i++) {
            Node temp = new Node(in.get(i));
            curr.left = null;
            curr.right = temp;
            curr = temp;
        }

        //
        curr.left = null;
        curr.right = null;

        return newRoot;
    } // Find optimized approch

    Node inOrderToBST(int s, int e, ArrayList<Integer> in) {
        // base case
        if (s > e) {
            return null;
        }

        int mid = (s + e) / 2;
        Node root = new Node(in.get(mid));
        root.left = inOrderToBST(s, mid - 1, in);
        root.right = inOrderToBST(mid + 1, e, in);
        return root;
    }

    // since we've a clue that inorder of BST and balanced BST is equal
    static convertBstToBalancedBST(Node root){
       //Balanced BST: For every node, abs(h(left) - h(right)) <=1
        ArrayList<Integer> in = new ArrayList<Integer>();
        inOrder(root, in);
        int n = in.size();
        return inOrder(0, n-1, in);
    } // find reason why just consturcting BST from inOrder gives balanced bst

    // optimize solution without mini
    static Node solveBSTfromPreOrder(int[] preOrder, int mini, int maxi, AtomicInteger i) {
        if (i.get() >= preOrder.length) {
            return null;
        }

        if (preOrder[i] < mini || preOrder[i] > maxi) { // avoiding numbers not in the range(mini,maxi)
            return null;
        }

        Node root = new Node(preOrder[i.getAndIncrement()]);
        root.left = solveBSTfromPreOrder(preOrder, mini, root.data, i);
        root.right = solveBSTfromPreOrder(preOrder, root.data, maxi, i);
        return root;
    }

    // Approach 1 : find every node and insert into BST - O(N^2)
    // Approach 2 : sort it, we'll get inorder, construct bst using inorder &
    // preOrder - O(NlogN)
    // Approach 3 : range based insertion (-inf, +inf) -- O(kN)
    static Node BSTfromPreOrder(int[] preOrder) {
        int mini = Integer.MIN_VALUE;
        int maxi = Integer.MAX_VALUE;
        AtomicInteger i = new AtomicInteger(0);
        return solveBSTfromPreOrder(preOrder, mini, maxi, i);
    }

    public static void main(String[] args) {

    }
}