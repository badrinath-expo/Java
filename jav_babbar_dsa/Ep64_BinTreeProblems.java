import java.util.*;
import java.util.LinkedList;

public class Ep64_BinTreeProblems {
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

  static ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
          int size = q.size();
          int ans[] = new int[size];

          for (int i = 0; i < size; i++) {
            
              Node frontNode = q.peek();
              q.remove();

              int index = leftToRight ? i:size-i-1;
              ans[index]=frontNode.data;

              if(frontNode.left!=null){
                q.add(frontNode.left);
              }

              if(frontNode.right!=null){
                q.add(frontNode.right);
              }
                  
        }
        leftToRight = !leftToRight;
        for(Integer i:ans){
            result.add(i);
        }
    }
    return result;
    }

    //Do remaining traversal questions as home work
    public static void main(String[] args) {
  

    }
}
