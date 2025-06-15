public class Ep68_FlattenBinaryTreeToLL {
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

    static void flatten(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node pred = curr.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }

        // //left part null
        // curr = root;
        // while(curr!=null){
        //     curr.left = null;
        //     curr = curr.right;
        // }
    }

    public static void main(String[] args) {

    }
}