
class CircularLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node tail = null;

    public void insertNode(int data, int element) {
        Node newNode = new Node(data);

        // emptylist
        if (this.tail == null) {
            this.tail = newNode;
            newNode.next = newNode;
        } else {
            // non-empty, Assuming element is present in list
            Node curr = this.tail;

            while (curr.data != element) {
                curr = curr.next;
            }

            // element found -> curr is representing element's node
            Node temp = new Node(data);
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    public void deleteNode(int value) {

        if (this.tail == null) {
            return;
        }

        Node prev = this.tail;
        Node curr = prev.next;

        while (curr.data != value) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        curr.next = null;

    }

    public void printLL() {
        Node temp = tail;
        if (temp == null) {
            return;
        }

        System.out.print(temp.data + " ");
        temp = temp.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != tail);
        System.out.println();
    }

    public boolean isCircularList(Node head) {
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

public class Ep44_CircularLL {
    public static void main(String[] args) {
        CircularLL ll = new CircularLL();

        ll.insertNode(1, 0);
        ll.insertNode(2, 1);
        ll.insertNode(3, 2);

        System.out.println(ll.tail.data);

        System.out.println(ll.isCircularList(ll.tail));//true

        ll.printLL();
    }
}
