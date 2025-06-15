public class Ep63_BinaryTreeInterview {
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

    public class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    int height(Node node) {
        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;
    }

    int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int op1 = diameter(root.left);
        int op2 = diameter(root.right);
        int op3 = height(root.left) + 1 + height(root.right);
        int ans = Math.max(op1, Math.max(op2, op3));
        return ans;
    } // O(N^2)

    Pair<Integer, Integer> diameterFast(Node root) { // first:diameter, second:height
        if (root == null) {
            return new Pair<Integer, Integer>(0, 0);
        }

        Pair<Integer, Integer> left = diameterFast(root.left);
        Pair<Integer, Integer> right = diameterFast(root.right);
        int op1 = left.first;
        int op2 = right.first;
        int op3 = left.second + 1 + right.second;
        int ansFirst = Math.max(op1, Math.max(op2, op3));
        int ansSecond = Math.max(left.second, right.second) + 1;
        return new Pair<Integer, Integer>(ansFirst, ansSecond);
    } // O(N)

    // isBalanced : every node abs[heigh(left) - height(right)] <=1
    boolean isBalanced(Node root) {
        if (root == null)
            return true;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        boolean diff = Math.abs(height(root.left) - height(root.right)) <= 1;
        return left && right && diff;
    } // O(N^2)

    Pair<Boolean, Integer> isBalancedFast(Node root) {
        if (root == null)
            return new Pair<Boolean, Integer>(true, 0);

        Pair<Boolean, Integer> left = isBalancedFast(root.left);
        Pair<Boolean, Integer> right = isBalancedFast(root.right);

        boolean leftAns = left.first;
        boolean rightAns = right.first;
        boolean diff = Math.abs(left.second - right.second) <= 1;

        Pair<Boolean, Integer> ans = new Pair<Boolean, Integer>(leftAns && rightAns && diff,
                Math.max(left.second, right.second) + 1);

        return ans;
    } // O(N)

    // Homework: Determine if 2 trees are identical

    // check sum true or not, for every node x, x = L + R
    Pair<Boolean, Integer> isSumTree(Node root) {
        if (root == null)
            return new Pair<Boolean, Integer>(true, 0);

        if(root.left == null && root.right == null){
            return new Pair<Boolean,Integer>(true, root.data);
        }

        Pair<Boolean, Integer> left = isSumTree(root.left);
        Pair<Boolean, Integer> right = isSumTree(root.right);

        boolean leftAns = left.first;
        boolean rightAns = right.first;
        boolean condition = (left.second + right.second) == root.data;

        Pair<Boolean, Integer> ans = new Pair<Boolean, Integer>(leftAns && rightAns && condition,
                (left.second + right.second + root.data));

        return ans;
    }

    public static void main(String[] args) {

    }
}
