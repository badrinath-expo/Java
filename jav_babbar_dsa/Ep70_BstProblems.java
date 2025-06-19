import java.util.concurrent.atomic.AtomicInteger;

public class Ep70_BstProblems {
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

    public static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data >= min && root.data <= max) {
            boolean left = isBST(root.left, min, root.data);
            boolean right = isBST(root.right, root.data, max);
            return left && right;
        } else {
            return false;
        }
    }

    static boolean validateBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // inorder traversal gives ascending order
    static int solveKthSmallestElementInBST(Node root, AtomicInteger k) {
        // verify in coding ninjas editor

        if (root == null) {
            return -1;
        }

        int left = solveKthSmallestElementInBST(root.left, k);

        if (left != -1) {
            return left;
        }

        if (k.decrementAndGet() == 0) {
            return root.data;
        }

        return solveKthSmallestElementInBST(root.right, k);
    }// T.C - O(N) S.C - O(N) // solve this question in Morris Traversal to get Space
     // O(1)

    // For kth largest, we can find for n-kth element
    static int kthSmallestElementinBST(Node root, int k) {
        AtomicInteger K = new AtomicInteger(k);

        return solveKthSmallestElementInBST(root, K);
    }

    // predecessor - max Element in left sub tree
    // successor - min element in right sub tree

    Pair<Integer, Integer> predecessorSuccessor(Node root, int key) {
        // find key
        Node temp = root;
        int pred = -1;
        int succ = -1;

        while (temp.data != key) {
            if (temp.data > key) {
                succ = temp.data;
                temp = temp.left;
            } else {
                pred = temp.data;
                temp = temp.right;

            }
        }

        // pred
        Node leftTree = temp.left;

        while (leftTree != null) {
            pred = leftTree.data;
            leftTree = leftTree.right;
        }

        // succ
        Node rightTree = temp.right;

        while (rightTree != null) {
            pred = rightTree.data;
            rightTree = rightTree.left;
        }

        return new Pair<Integer, Integer>(pred, succ);
    } // O(N) S.C - O(1)

    // observe conditions in logic and take a sample tree
    static Node lcaInBST(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        if (root.data < p.data && root.data < q.data) {
            return lcaInBST(root.right, p, q);
        }

        if (root.data > p.data && root.data > q.data) {
            return lcaInBST(root.left, p, q);
        }

        return root;
    }

    static lcaInBSTIterative(Node root,Node p, Node q){
              if(root == null){
        return null;
       }

while(root!=null){
       if(root.data < p.data && root.data < q.data){
        root = root.right;
       } else if(root.data > p.data && root.data > q.data){
        root = root.left;
       } else{
       return root; 
       }
    }

    return null;
    }

    public static void main(String[] args) {

    }
}