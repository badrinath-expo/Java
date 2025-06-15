import java.util.Stack;

public class Ep59_SpecialStack {

    class SpecialStack {
        Stack<Integer> s;
        int mini;

        SpecialStack() {
            s = new Stack<>();
            mini = Integer.MAX_VALUE;
        }

        void push(int data) {
            if (s.empty()) {
                s.push(data);
                mini = data;
            } else {
                if (data < mini) {
                    int val = (2 * data) - mini;
                    s.push(val);
                    mini = data;
                } else {
                    s.push(data);
                }
            }
        }

        int pop() {
            if (s.empty())
                return -1;
            int curr = s.peek();
            s.pop();
            if (curr > mini) {
                return curr;
            } else {
                int prevMin = mini;
                int val = (2 * mini) - curr;
                mini = val;
                return prevMin;
            }
        }

        int top() {
            if (s.empty())
                return -1;
            int curr = s.peek();
            if (curr < mini) {
                return mini;
            } else {
                return curr;
            }
        }

        boolean isEmpty() {
            return s.empty();
        }

        int getMin() {
            if (s.empty()) {
                return -1;
            }
            return mini;
        }

    }

    public static void main(String[] args) {

    }
}
