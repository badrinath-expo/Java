class Node49 {
    int data;
    Node49 next;

    Node49(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList49 {

    Node49 head = null;
    Node49 tail = null;

    public void addNodeAtTail(int data) { // O(1)
        Node49 newNode49 = new Node49(data);
        if (head == null) {
            this.head = newNode49;
            this.tail = newNode49;
            return;
        }

        tail.next = newNode49;
        tail = newNode49;
    }
}

public class Ep49_LLproblems {

    public static Node49 merge(Node49 head1, Node49 head2) {

        Node49 dummy = new Node49(-1);
        Node49 temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Linkedlist : Sort 0 1 2
        /*
         * Approach1: find count of Os and 1s and 2s, then, insert into LL
         * Approach2: data replacement is not allowed.
         * - zero Node49s
         * - one Node49s
         * - two Node49s
         * merge them
         */
        // Solve on your own.

        // Merge 2 sorted LL
        LinkedList49 ll1 = new LinkedList49();
        ll1.addNodeAtTail(1);
        ll1.addNodeAtTail(3);
        ll1.addNodeAtTail(6);

        LinkedList49 ll2 = new LinkedList49();
        ll2.addNodeAtTail(2);
        ll2.addNodeAtTail(4);
        ll2.addNodeAtTail(5);

        Node49 mergedHead = merge(ll1.head, ll2.head);
        Node49 temp = mergedHead;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
