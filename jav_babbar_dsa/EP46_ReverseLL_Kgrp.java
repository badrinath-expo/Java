class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
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
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public Node kReverse(Node head, int k) {
        // base case
        if (head == null) {
            return null;
        }

        // step1 reverse first k nodes
        Node next = null;
        Node curr = head;
        Node prev = null;

        int ct = 0;

        while (curr != null && ct < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            ct++;
        }

        // step2: recursive calls
        if (next != null) {
            head.next = kReverse(next, k);
        }

        // step3:return head of reversed list
        return prev;
    }

    public boolean isCircularList() { 
        if (head == null) {
            return true;
        }

        Node curr = head.next;
        while (curr != null && curr != head) {
            curr = curr.next;
        }

        if (curr == head) {
            return true;
        }

        return false;
    }
}

public class EP46_ReverseLL_Kgrp {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addNodeAtTail(1);
        ll.addNodeAtTail(2);
        ll.addNodeAtTail(3);
        ll.addNodeAtTail(4);
        ll.addNodeAtTail(5);
        ll.addNodeAtTail(6);

        Node head = ll.kReverse(ll.head, 2);

        ll.printLL(head);

    }
}
