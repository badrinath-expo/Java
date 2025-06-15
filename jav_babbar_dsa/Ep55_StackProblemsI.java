import java.util.*;

public class Ep55_StackProblemsI {

    static String reverseStringUsingStack(String s) {
        String res = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        while (!st.empty()) {
            char ch = st.peek();
            res += ch;
            st.pop();
        }
        return res;
    }

    static void solve(Stack<Integer> inputStack, int count, int size) {
        if (count == size / 2) {
            inputStack.pop();
            return;
        }
        int num = inputStack.peek();
        inputStack.pop();
        solve(inputStack, count + 1, size);
        inputStack.push(num);
    }

    static boolean balancedParenthesis(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('{', -1);
        map.put('}', 1);
        map.put('(', -2);
        map.put(')', 2);
        map.put('[', -3);
        map.put(']', 3);

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < 0) {
                st.push(s.charAt(i));
            } else {
                if (st.empty() || (map.get(st.peek()) + map.get(s.charAt(i))) != 0) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        return st.empty();
    }

    static void insertAtBottom(Stack<Integer> s, int element) {
        // base case
        if (s.empty()) {
            s.push(element);
            return;
        }

        int num = s.peek();
        s.pop();

        insertAtBottom(s, element);
        s.push(num);
    }

    public static void reverseStack(Stack<Integer> st) {
        if (st.empty()) {
            return;
        }

        int num = st.peek();
        st.pop();
        reverseStack(st);
        insertAtBottom(st, num);
    }

    static void sortedInsert(Stack<Integer> s, int num) {
        // base case
        if (s.empty() || (!s.empty() && (s.peek() < num))) {
            s.push(num);
            return;
        }

        int n = s.peek();
        s.pop();

        sortedInsert(s, num);
        s.push(n);
    }

    static void sortStack(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }

        int num = s.peek();
        s.pop();
        sortStack(s);
        sortedInsert(s, num);
    }

    public static void main(String[] args) {
        // System.out.println(reverseStringUsingStack("abcd"));
        // System.out.println(balancedParenthesis("{}{}}"));
        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);

        // reverseStack(st);
        // while (!st.empty()) {
        // System.out.print(st.peek() + " ");
        // st.pop();
        // }
        // System.out.println();

        /*
         * Sorted stack
         */
        Stack<Integer> s = new Stack<>();
        s.push(11);
        s.push(44);
        s.push(22);
        s.push(33);

        sortStack(s);
        System.out.print("sorted: ");
        while (!s.empty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();

    }
}
