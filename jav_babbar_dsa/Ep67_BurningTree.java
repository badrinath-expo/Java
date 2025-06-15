import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Ep67_BurningTree {

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

  // create mapping & return target Node
    static Node createParentMapping(Node root, int target, Map<Node, Node> nodeToParent) {

        Node res = null;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        nodeToParent.put(root, null);

        while (!q.isEmpty()) {
            Node front = q.peek();
            q.remove();

            if (front.data == target) {
                res = front;
            }

            if (front.left != null) {
                nodeToParent.put(front.left, front);
                q.add(front.left);
            }

            if (front.right != null) {
                nodeToParent.put(front.right, front);
                q.add(front.right);
            }
        }

        return res;
    }

    static int burnTree(Node root, Map<Node, Node> nodeToParent) {
Map<Node,Boolean> visited = new HashMap<>();
    Queue<Node> q = new LinkedList<>();

        q.add(root);
        visited.put(root,true);

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
boolean flag = false;
            for (int i = 0; i < size; i++) {
                //process neighbouring nodes
                Node front = q.peek();
                q.remove();
                if(front.left!=null && !visited.getOrDefault(front.left, false)){
                  flag=true;
                    q.add(front.left);
                  visited.put(front.left,true);
                }

                if(front.right!=null && !visited.getOrDefault(front.right,false)){
                  flag=true;
                    q.add(front.right);
                  visited.put(front.right,true);
                }

             if(nodeToParent.get(front)!=null && !visited.getOrDefault(nodeToParent.getOrDefault(front, null),false)){
                 flag=true;
                q.add(nodeToParent.get(front));
                  visited.put(nodeToParent.get(front),true);
                }
            }
            if(flag){
                ans++;
            }
        }
return ans;
    }
    public static int minTime(Node root, int target) {
        // code here
        // Step1: Map node to parent
        // step2 : find target node
        // step3: burn the tree in min time
        Map<Node, Node> nodeToParent = new HashMap<>();
        Node targetNode = createParentMapping(root, target, nodeToParent);
        return burnTree(targetNode, nodeToParent);
    }

    public static void main(String[] args) {

    }
}
