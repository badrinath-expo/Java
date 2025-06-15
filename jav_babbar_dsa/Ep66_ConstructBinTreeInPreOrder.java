import java.util.concurrent.atomic.AtomicInteger;

public class Ep66_ConstructBinTreeInPreOrder {

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

    public int findPosition(int in[], int element, int n) {
        for (int i = 0; i < in.length; i++) { // optimize this method by using hashing
            if (in[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public Node solveBuildTreeFromInPreOrder(int in[], int pre[], AtomicInteger index, int inOrderStart, int inOrderEnd, int n) {
        // base case
        if (index.get() >= n || inOrderStart > inOrderEnd) {
            return null;
        }

        int element = pre[index.getAndIncrement()];
        Node root = new Node(element);
        int position = findPosition(in, element, n);

        // recursive calls
        root.left = solveBuildTreeFromInPreOrder(in, pre, index, inOrderStart, position - 1, n);
        root.right = solveBuildTreeFromInPreOrder(in, pre, index, position + 1, inOrderEnd, n);
        return root;
    }

    public Node buildTreeFromInPreOrder(int in[], int pre[], int n) {
        AtomicInteger preOrderIndex = new AtomicInteger(0);

        Node ans = solveBuildTreeFromInPreOrder(in, pre, preOrderIndex, 0, n - 1, n);
        return ans;
    }

    public static void main(String[] args) {

    }
}