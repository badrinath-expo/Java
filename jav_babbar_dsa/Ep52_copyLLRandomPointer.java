import java.util.HashMap;
import java.util.Map;

class Node52 {
    int data;
    Node52 next;
    Node52 random;

    Node52(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class LinkedList52 {

    Node52 head = null;
    Node52 tail = null;

    public void addNodeAtTail(int data) { // O(1)
        Node52 newNode = new Node52(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }
}

public class Ep52_copyLLRandomPointer {

    static Node52 createClone(Node52 head) {
        LinkedList52 clonell = new LinkedList52();

        Node52 temp = head;

        while (temp != null) {
            clonell.addNodeAtTail(temp.data);
            temp = temp.next;
        }

        Map<Node52, Node52> oldToNew = new HashMap<>();

        Node52 originalNode = head;

        Node52 cloneNode = clonell.head;

        while (originalNode != null && cloneNode != null) {
            oldToNew.put(originalNode, cloneNode);

            originalNode = originalNode.next;
            cloneNode = cloneNode.next;
        }

        originalNode = head;
        cloneNode = clonell.head;

        while (originalNode != null && cloneNode != null) {
            cloneNode.random = oldToNew.get(originalNode);
            originalNode = originalNode.next;
            cloneNode = cloneNode.next;
        }

        return clonell.head;
    } // space O(n) time - O(n)

    static Node52 createCloneOptimized(Node52 head) {
        // code here
        LinkedList52 clonell = new LinkedList52();

        Node52 temp = head;

        while (temp != null) {
            clonell.addNodeAtTail(temp.data);
            temp = temp.next;
        }

        Node52 originalNode = head;
        Node52 cloneNode = clonell.head;
        // step2: point orignal <-> clone
        while (originalNode != null && cloneNode != null) {
            Node52 originalNodeNext = originalNode.next;
            Node52 cloneNodeNext = cloneNode.next;
            originalNode.next = cloneNode;
            cloneNode.next = originalNodeNext;
            cloneNode = cloneNodeNext;
            originalNode = originalNodeNext;
        }

        temp = head;
        // step 3: random pointer copy
        while (temp != null) {
            if (temp.next != null) {
                temp.next.random = (temp.random != null) ? temp.random.next : temp.random;
            }
            temp = temp.next.next;
        }

        originalNode = head;
        cloneNode = clonell.head;
        while (originalNode != null && cloneNode != null) {
            originalNode.next = cloneNode.next;
            originalNode = originalNode.next;

            if (originalNode != null) {
                cloneNode.next = originalNode.next;
                cloneNode = cloneNode.next;
            }
        }
        return clonell.head;
    }

    public static void main(String[] args) {

    }
}