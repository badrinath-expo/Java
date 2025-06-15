import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ep62_BinaryTree {

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

    static Node buildTree(Node root, Scanner sc) {
        System.out.println("enter the data:");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = new Node(data);
        System.out.println("entering data for left of node:" + data);
        root.left = buildTree(root.left, sc);
        System.out.println("entering data for right of node" + data);
        root.right = buildTree(root.right, sc);
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

    static void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    static Node buildFromLevelOrderTraversal(Node root, Scanner sc) {
        Queue<Node> q = new LinkedList<>();
        System.out.println("enter data for root");
        int data = sc.nextInt();
        root = new Node(data);
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();

            System.out.print("enter left node for: " + temp.data + " ");
            int leftData = sc.nextInt();
            if (leftData != -1) {
                Node newNode = new Node(leftData);
                temp.left = newNode;
                q.add(newNode);
            }

            System.out.print("enter right node for: " + temp.data + " ");
            int rightData = sc.nextInt();
            if (rightData != -1) {
                Node newNode = new Node(rightData);
                temp.right = newNode;
                q.add(newNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        Scanner sc = new Scanner(System.in);

        // root = buildTree(root, sc);

        // System.out.println("printing the level order traversal");

        // levelOrderTraversal(root);

        // inOrderTraversal(root);

        root = buildFromLevelOrderTraversal(root, sc);
        levelOrderTraversal(root);

    }
}

// 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

/*
 * Level order traversal
 * 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
 * entering data for left of node:1
 * enter the data:
 * entering data for left of node:3
 * enter the data:
 * entering data for left of node:7
 * enter the data:
 * entering data for right of node7
 * enter the data:
 * entering data for right of node3
 * enter the data:
 * entering data for left of node:11
 * enter the data:
 * entering data for right of node11
 * enter the data:
 * entering data for right of node1
 * enter the data:
 * entering data for left of node:5
 * enter the data:
 * entering data for left of node:17
 * enter the data:
 * entering data for right of node17
 * enter the data:
 * entering data for right of node5
 * enter the data:
 * printing the level order traversal
 * 1
 * 3 5
 * 7 11 17
 */

/*
 * 
 * Homework:
 * Find th cout of no.of leaf nodes
 * **Imp Iterative InOrder, preOrder, PostOrder traversal
 */