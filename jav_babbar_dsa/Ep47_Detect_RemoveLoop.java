import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LL {
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

    boolean detectLoopUsingMap() {

        if (head == null)
            return false;

        Map<Node, Boolean> visited = new HashMap<>();

        Node temp = head;

        while (temp != null) {

            // cycle is present
            if (visited.getOrDefault(temp, false) == true) {
                return true;
            }

            visited.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    Node floydDetectLoop() {
        if (head == null)
            return null;

        Node slow = head, fast = head;

        while (slow != null && fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
            }

            slow = slow.next;

            if (slow == fast) {
                return slow; // one of the node in loop
            }
        }

        return null;
    }

    Node getStartingNodeOfLoop() {
        if (head == null)
            return null;

        Node intersection = floydDetectLoop();

        Node slow = head;

        while (slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }
        return slow;
    }

    void removeLoop() {
        if (head == null)
            return;

        Node startOfLoop = getStartingNodeOfLoop();
        if(startOfLoop == null) return;

        Node temp = startOfLoop;
        while (temp.next != startOfLoop) {
            temp = temp.next;
        }

        temp.next = null;
    }
}

public class Ep47_Detect_RemoveLoop {
    public static void main(String[] args) {
        LL ll = new LL();

        ll.addNodeAtTail(1);
        ll.addNodeAtTail(2);
        ll.addNodeAtTail(3);

        ll.tail.next = ll.head;

        System.out.println(ll.detectLoopUsingMap());

        System.out.println(ll.floydDetectLoop() == null ? "no cycle" : "cycle exists");

    }
}
