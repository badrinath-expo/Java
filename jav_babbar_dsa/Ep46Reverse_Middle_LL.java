
class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNodeAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addNodeAtTail(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            this.head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        Node currTempNext = temp.next;

        if (temp.next == null) {
            this.tail = newNode;
        }
        temp.next = newNode;
        newNode.next = currTempNext;
    }

    public void deleteNodeAtPos(int pos) {

        if (pos == 0) {
            this.head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        Node nextNode = temp.next.next;
        if (nextNode == null) {
            this.tail = temp;
        }
        temp.next = nextNode;
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void iterativeReverseLL() {
        if (this.head == null || head.next == null)
            return;

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            if (curr.next == null) {
                this.tail = this.head;
                this.head = curr;
            }
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public void recursiveReverseLL(Node head, Node curr, Node prev) {
        if (curr == null) {
            this.tail = this.head;
            this.head = prev;
            return;
        }

        Node next = curr.next;
        recursiveReverseLL(head, next, curr);
        curr.next = prev;
    }

    public void anotherWayOfReverse(Node head) {

        if (head == null || head.next == null) {
            this.tail = this.head;
            this.head = head;
            return;
        }

        anotherWayOfReverse(head.next);
        head.next.next = head;
        head.next = null;
    }

    int getLength() {
        Node temp = this.head;

        int ct = 0;
        while (temp != null) {
            ct++;
        }
        return ct;
    }

    public Node getMiddleNode() {
        int len = getLength();

        int ans = (len / 2);

        Node temp = this.head;
        int ct = 0;

        while (ct < ans) {
            temp = temp.next;
            ct++;
        }
        return temp;
    }

    // Optimized middle finding
    public Node optimizedGetMiddleNode() {

    if (this.head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
        }
        return slow;
    }
}

public class Ep46Reverse_Middle_LL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNodeAtTail(1);
        ll.addNodeAtTail(2);
        ll.addNodeAtTail(3);
        // ll.iterativeReverseLL();
        ll.recursiveReverseLL(ll.head, ll.head, null);
        // ll.anotherWayOfReverse(ll.head);
        ll.printLL();
    }

}
