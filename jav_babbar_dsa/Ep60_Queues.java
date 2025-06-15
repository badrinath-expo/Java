import java.util.LinkedList;
import java.util.Queue;

public class Ep60_Queues {

    class QueueUsingArrays {
        int arr[];
        int front;
        int rear;
        int size;

        public QueueUsingArrays() {
            size = 100001;
            arr = new int[size];
            front = 0;
            rear = 0;
        }

        void enqueue(int data) {
            if (rear == size) {
                System.out.println("Queue full");
            } else {
                arr[rear++] = data;
            }
        }

        boolean isEmpty() {// O(1)
            return front == rear;
        }

        int dequeue() { // O(1)
            if (front == rear) {
                return -1;
            } else {
                int ans = arr[front];
                arr[front] = -1;
                front++;
                if (front == rear) {
                    front = 0;
                    rear = 0;
                }
                return ans;
            }
        }

        int peek() { // O(1)
            if (front == rear) {
                return -1;
            }

            return arr[front];
        }

    }

    class CircularQueue {
        int arr[];
        int front;
        int rear;
        int size;

        public CircularQueue(int n) {
            size = n;
            arr = new int[size];
            front = rear = -1;
        }

        void enqueue(int value) {
            if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
                System.out.println("Queue full");
                return;
            } else if (front == -1) { // first element
                front = rear = 0;
            } else if (rear == size - 1 && front != 0) {
                rear = 0;
            } else { // normal flow
                rear++;
            }
            arr[rear] = value;
        }

        boolean isEmpty() {// O(1)
            return front == rear;
        }

        int dequeue() { // O(1)
            if (front == -1) { // to check queue empty
                System.out.println("Queue is empty");
                return -1;
            } else {
                int ans = arr[front];
                arr[front] = -1;
                if (front == rear) { // single element
                    front = rear = -1;
                } else if (front == size - 1) {
                    front = 0;
                } else {
                    front++;
                }
                return ans;
            }
        }

        int peek() { // O(1)
            if (front == rear) {
                return -1;
            }

            return arr[front];
        }
    }

    class DeQueue {
        int arr[];
        int front;
        int rear;
        int size;

        public DeQueue(int n) {
            size = n;
            arr = new int[size];
            front = rear = -1;
        }

        void push_front(int value) {
            if (isFull()) {
                System.out.println("Queue full");
                return;
            } else if (isEmpty()) { // first element
                front = rear = 0;
            } else if (front == 0 && rear != size - 1) { // cyclic nature
                front = size - 1;
            } else { // normal flow
                front--;
            }
            arr[front] = value;
        }

        void push_rear(int value) {
            if (isFull()) {
                System.out.println("Queue full");
                return;
            } else if (isEmpty()) { // first element
                front = rear = 0;
            } else if (rear == size - 1 && front != 0) { // cyclic nature
                rear = 0;
            } else { // normal flow
                rear++;
            }
            arr[rear] = value;
        }

        boolean isEmpty() {// O(1)
            return front == -1;
        }

        boolean isFull() {
            return ((front == 0 && rear == size - 1) || (front != 0 && (rear == ((front - 1) % (size - 1)))));
        }

        int popfront() { // O(1)
            if (isEmpty()) { // to check queue empty
                System.out.println("Queue is empty");
                return -1;
            } else {
                int ans = arr[front];
                arr[front] = -1;
                if (front == rear) { // single element
                    front = rear = -1;
                } else if (front == size - 1) {
                    front = 0;
                } else {
                    front++;
                }
                return ans;
            }
        }

        int popRear() { // O(1)
            if (isEmpty()) { // to check queue empty
                System.out.println("Queue is empty");
                return -1;
            } else {
                int ans = arr[rear];
                arr[front] = -1;
                if (front == rear) { // single element
                    front = rear = -1;
                } else if (front == 0) {
                    rear = size - 1;
                } else {
                    rear--;
                }
                return ans;
            }
        }

        int peek() { // O(1)
            if (isEmpty()) {
                return -1;
            }

            return arr[front];
        }

        int getRear() { // O(1)
            if (isEmpty()) {
                return -1;
            }

            return arr[rear];
        }
    }

    public static void main(String[] args) {
    }
}
