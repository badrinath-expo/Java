import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Ep65_TreeProblems {
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
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static void solveSumOfLongRootToLeafPath(Node root, int sum, int len, Pair<Integer, Integer> maxSumLen) {
        if (root == null) {
            if (len > maxSumLen.second) {
                maxSumLen.first = sum;
                maxSumLen.second = len;
            } else if (len == maxSumLen.second) {
                maxSumLen.first = Math.max(maxSumLen.first, sum);
            }
            return;
        }
        sum = sum + root.data;

        solveSumOfLongRootToLeafPath(root.left, sum, len + 1, maxSumLen);
        solveSumOfLongRootToLeafPath(root.right, sum, len + 1, maxSumLen);
    }

    static int sumOfLongRootToLeafPath(Node root) {
        int len = 0;
        int sum = 0;
        Pair<Integer, Integer> p = new Pair<Integer, Integer>(0, Integer.MIN_VALUE);

        solveSumOfLongRootToLeafPath(root, sum, len, p);
        return p.second;
    } // O(H)

    Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data == n1 && root.data == n2) {
            return root;
        }

        Node leftAns = lca(root.left, n1, n2);
        Node rightAns = lca(root.right, n1, n2);
        if (leftAns != null && rightAns != null) {
            return root;
        } else {
            return leftAns != null ? leftAns : rightAns;
        }
    }

    static void solveKsumPaths(Node root, int k, AtomicInteger count, ArrayList<Integer> path) {
        if (root == null)
            return;

        path.add(root.data);

        solveKsumPaths(root.left, k, count, path);
        solveKsumPaths(root.right, k, count, path);

        // check for k sum
        int size = path.size();

        int sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                count.incrementAndGet();
            }
        }
        // removing from path when going up
        path.remove(path.size() - 1);
    }

    int kSumPaths(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);
        solveKsumPaths(root, k, count, path);
        return count.get();
    }

    Node solvekthAncestor(Node root, int node, AtomicInteger k) {
        if (root == null)
            return null;

        if (root.data == node) {
            return root;
        }

        Node leftAns = solvekthAncestor(root.left, node, k);
        Node rightAns = solvekthAncestor(root.right, node, k);
        if (leftAns != null && rightAns == null) {
            k.decrementAndGet();
            if (k.get() <= 0) {
                // answer lock
                k.set(Integer.MAX_VALUE);
                return root;
            }
            return leftAns;
        }

        if (leftAns != null && rightAns == null) {
            k.decrementAndGet();
            if (k.get() <= 0) {
                // answer lock
                k.set(Integer.MAX_VALUE);
                return root;
            }
            return rightAns;
        }
        return null;
    }

    int kthAncestor(Node root, int k, int node) {
        AtomicInteger K = new AtomicInteger(k);
        Node ans = solvekthAncestor(root, node, K);
        if (ans == null || ans.data == node) {
            return -1;
        }
        return ans.data;
    }
    // Maximum sum of non adjacent nodes

    static Pair<Integer, Integer> solveMaxSumOfNonAdjNodes(Node root) {
        // base case
        if (root == null) {
            return new Pair<Integer, Integer>(0, 0);
        }

        Pair<Integer, Integer> left = solveMaxSumOfNonAdjNodes(root.left);
        Pair<Integer, Integer> right = solveMaxSumOfNonAdjNodes(root.right);

        int resFirst = root.data + left.second + right.second;
        int resSecond = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        Pair<Integer, Integer> res = new Pair<Integer, Integer>(resFirst, resSecond);
        return res;
    }

    static int getMaxSum(Node root) {
        Pair<Integer, Integer> ans = solveMaxSumOfNonAdjNodes(root);
        return Math.max(ans.first, ans.second);
    }

    public static void main(String[] args) {

    }
}