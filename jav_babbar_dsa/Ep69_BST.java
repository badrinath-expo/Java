import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Ep69_BST {
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

    static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data <= root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }

        return root;
    }

    static Node takeInput(Node root, Scanner sc) {
        int data = sc.nextInt();
        while (data != -1) {
            root = insertIntoBST(root, data);
            data = sc.nextInt();
        }

        return root;
    }

    static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            if (temp == null) {
                System.out.println(); // prev level done
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    static boolean searchInBST(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        boolean ans = false;
        if (key <= root.data) {
            ans |= searchInBST(root.left, key);
        } else {
            ans |= searchInBST(root.right, key);
        }

        return ans;
    }

    static boolean searchInBSTOptimized(Node root, int key) {
        Node temp = root;

        while (temp != null) {
            if (temp.data == key)
                return true;
            if (key < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return false;
    }

    static Node getMinNode(Node root){

    Node temp = root;

    while (temp.left!=null) {
        temp = temp.left;
    }

    return temp;
         
    }

        static Node getMaxNode(Node root){

    Node temp = root;

    while (temp.right!=null) {
        temp = temp.right;
    }

    return temp;
         
    }

    // Deleting a node in BST
    // 1. 0 child 2. 1 child 3. 2 childs
    static Node deleteNodeInBST(Node root, int val) {
        if (root == null) {
            return root;
        }

        if (root.data == val) {
            // 0 child
            if (root.left == null && root.right == null) {
                return null;
            }

            // 1 child
            if (root.left != null && root.right == null) {
                Node temp = root.left;
                return temp;
            }

            if (root.left == null && root.right != null) {
                Node temp = root.right;
                return temp;
            }

            // 2 childs

            if (root.left != null && root.right != null) {
                int mini = getMinNode(root.right).data;
                root.data = mini;
                root.right = deleteNodeInBST(root.right, mini);
                return root;
            }

        }

        if (val < root.data) {
            root.left = deleteNodeInBST(root.left, val);
        } else {
            root.right = deleteNodeInBST(root.right, val);
        }

        return root;
    } //O(h) O(N)

    // For every node, left subtree nodes will be less than the node, and right
    // subtree nodes will be greater than the node
    public static void main(String[] args) {
        Node root = null;

        System.out.println("enter data");

        Scanner sc = new Scanner(System.in);

        root = takeInput(root, sc);

        // System.out.println("printing LL");
        // levelOrderTraversal(root);
        /*
         * enter data
         * 10 8 21 7 27 5 4 3 -1
         * printing LL
         * 10
         * 8 21
         * 7 27
         * 5
         * 4
         * 3
         */
        // InOrder traversal for BST is ascending order
        System.out.println(searchInBST(root, 77));
    }
}

// min value ==> go to left until null
// max value ==> go to right until null
// Homework inorder successor, predecessor