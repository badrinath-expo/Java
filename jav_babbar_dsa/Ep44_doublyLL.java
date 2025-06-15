
class DoublyLL {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null, tail = null;

    public void addNodeAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        head.prev = newNode;
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

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }

    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head.prev = newNode;
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
        newNode.prev = temp;
        temp.next = newNode;
        newNode.next = currTempNext;
    }

    public void deleteNodeAtPos(int pos) {

        if (pos == 0) {
            this.head = head.next;
            head.prev = null;
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

        if(nextNode!=null){
            nextNode.prev = temp;
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
}

public class Ep44_doublyLL {

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();

        ll.addNodeAtTail(1);
        ll.addNodeAtTail(2);
        ll.addNodeAtTail(3);

        // ll.addNodeAtHead(1);
        // ll.addNodeAtHead(2);
        // ll.addNodeAtHead(3);
        
        ll.insertAtPosition(5, 0);
        ll.insertAtPosition(6, 3);

        ll.printLL();
        System.out.println("beforeDelete:: head: " + ll.head.data + " tail: " + ll.tail.data);
        ll.deleteNodeAtPos(4);
        System.out.println("Delete at 4th pos:: head: " + ll.head.data + " tail: " + ll.tail.data);
        ll.printLL();

        ll.deleteNodeAtPos(3);
        System.out.println("Delete at 3th pos:: head: " + ll.head.data + " tail: " + ll.tail.data);
        ll.printLL();

        ll.deleteNodeAtPos(2);
        System.out.println("Delete at 2th pos:: head: " + ll.head.data + " tail: " + ll.tail.data);
        ll.printLL();

        ll.deleteNodeAtPos(1);
        System.out.println("Delete at 1th pos:: head: " + ll.head.data + " tail: " + ll.tail.data);
        ll.printLL();
    }
}
