import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


//Dry run the logic, Find the stackoverflow case why the last 2 test cases are failing in coding ninjas
public class Ep72_Merge2Bsts {
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

    static void inOrder(Node root, List<Integer> in) {
        if (root == null) {
            return;
        }

        inOrder(root.left, in);
        in.add(root.data);
        inOrder(root.right, in);
    }

    static ArrayList<Integer> merge2SortedArrays(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                ans.add(a.get(i));
                i++;
            } else {
                ans.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            ans.add(a.get(i++));
        }

        while (j < b.size()) {
            ans.add(b.get(j++));
        }
        return ans;
    }

    static Node inOrderToBST(int s, int e, ArrayList<Integer> in) {
        // base case
        if (s > e) {
            return null;
        }

        int mid = (s + e) / 2;
        Node root = new Node(in.get(mid));
        root.left = inOrderToBST(s, mid - 1, in);
        root.right = inOrderToBST(mid + 1, e, in);
        return root;
    }

    /*
     * Approach 1:
     * i. get Inorder of 2 BSTS
     * ii. merge these 2 inorder
     * iii. construct BST from inorder
     * T.C - O(M+N) S.C - O(M+N) //unOptimized
     */
    static Node merge2BSTsApproach1(Node root1, Node root2) {
        ArrayList<Integer> bst1 = new ArrayList<Integer>();
        ArrayList<Integer> bst2 = new ArrayList<Integer>();
        inOrder(root1, bst1);
        inOrder(root2, bst2);

        ArrayList<Integer> mergeArray = merge2SortedArrays(bst1, bst2);
        int s = 0, e = mergeArray.size() - 1;
        return inOrderToBST(s, e, mergeArray);
    }

  /*********** Approach 2 *************/
    // flatten bsts to LL, merge those 2 LLs
    // step-1: flatten those BSTs T.C- O(M) O(N) SC - O(h1) O(h2)
    // step-2: merge 2 sorted LL T.C - O(M+N) S.C - O(1)
    // step-3: Sorted LL to BST should be S.C - O(h1+h2)

    static void convertIntoSortedDLL(Node root, AtomicReference<Node> head) {

        if (root == null) {
            return;
        }

        convertIntoSortedDLL(root.right, head);
        root.right = head.get();

        if (head.get() != null) {
            head.get().left = root;
        }

        head.set(root);

        convertIntoSortedDLL(root.left, head);
    }

    static Node mergeLL(Node head1, Node head2) {
        Node head = null;
        Node tail = null;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (head == null) {
                    head = head1;
                    tail = head1;
                    head1 = head1.right;
                } else {
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;
                }
            } else {
                if (head == null) {
                    head = head2;
                    tail = head2;
                    head2 = head2.right;
                } else {
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head2 = head2.right;
                }
            }
        }

        while (head1 != null) {
            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;
        }

        while (head2 != null) {
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head2 = head2.right;
        }
        return head;
    }


    static int countNodes(Node head){
        int cnt = 0;
        Node temp = head;
        while (temp!=null) {
            cnt++;
            temp = temp.right;
        }
        return cnt;
    }

    static Node sortedLLtoBST(AtomicReference<Node> head, int n){
 
    //base case
    if(n <= 0 || head == null){
        return null;
    }

    Node left = sortedLLtoBST(head, n/2);

    Node root = head.get();
     root.left = left;

     head.set(head.get().right);

     root.right = sortedLLtoBST(head, n - n/2 - 1);
     return root; 
    }

    static Node  merge2BSTsApproach2(Node root1, Node root2){
       
       //step1: convert bsts to sorted ll
        AtomicReference<Node> head1 = new AtomicReference<Node>();
        convertIntoSortedDLL(root1, head1);
        head1.get().left = null;
          AtomicReference<Node> head2 = new AtomicReference<Node>();
        convertIntoSortedDLL(root2, head2);
         head2.get().left = null;


         //step2:merge sorted LL
         Node head = mergeLL(head1.get(), head2.get());

         //convert sorted LL into BST
         return sortedLLtoBST(new AtomicReference<Node>(head), countNodes(head));
    }
    public static List<Integer> mergeBST(Node root1, Node root2) {
        // Write your code here.
        
     Node newRoot =  merge2BSTsApproach2(root1,root2);
    List<Integer> ans = new ArrayList<>();
    inOrder(newRoot,ans);
    return ans;
    
    }

    public static void main(String[] args) {

    }
}
