
class Stacks<T> {

    int size;
    int arr[];
    int peek;

    Stacks(int size) {
        this.size = size;
        arr = new int[size];
        peek = -1;
    }

    public void push(int data) {
        if (peek == (size - 1)) {
            System.out.println("stack overflow");
            return;
        }
        arr[++peek] = data;
    }

    public int top() {
        return peek == -1 ? null : arr[peek];
    }

    public void pop() {
        if (peek != -1) {
            peek--;
        } else {
            System.out.println("stack is empty");
        }
    }

    public boolean isEmpty() {
        return peek == -1;
    }

}

public class Ep54_Stacks {
    public static void main(String[] args) {
        Stacks st = new Stacks(1);
        st.push(1);
        // st.add(2);
        // st.add(3);
        st.push(4);
        System.out.println(st.top());
    }
}
