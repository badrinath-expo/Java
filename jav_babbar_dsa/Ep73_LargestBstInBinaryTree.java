public class Ep73_LargestBstInBinaryTree {
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

    static class Info {
        int maxi;
        int mini;
        boolean isBST;
        int size;

        Info(){
            
        }

        Info(int maxi, int mini, boolean isBST, int size) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBST = isBST;
            this.size = size;
        }
    }

    static Info solve(Node root, AtomicInteger ans) {
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }

        Info left = solve(root.left, ans);
        Info right = solve(root.right, ans);
        Info currNode = new Info();

        currNode.size = left.size + right.size + 1;
        currNode.maxi = Math.max(root.data, right.maxi);
        currNode.mini = Math.min(root.data, left.mini);
        currNode.isBST = left.isBST && right.isBST && (root.data > left.maxi && root.data < right.mini);

        if (currNode.isBST) {
            ans.set(Math.max(ans.get(), currNode.size));
        }

        return currNode;
    }

    int largestBST(Node root){
        AtomicInteger maxSize = new AtomicInteger(0);
        Info temp = solve(root, maxSize);
        return maxSize.get();
    }

    public static void main(String[] args) {

    }
}

/*
 * node -> isValidBST
 * i. left subtree valid bst O(1)
 * ii. right subtree valid BST O(1)
 * iii. max_left < root_data < mini_right
 */

/*
 * UnOptimized Approach: checking isBST at every node
 */