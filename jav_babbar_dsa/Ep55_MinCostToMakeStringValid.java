import java.util.Stack;

public class Ep55_MinCostToMakeStringValid {

    public static int findMinimumCost(String str) {
        if (str.length() % 2 == 1)
            return -1;

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{') {
                s.push(ch);
            } else {
                // ch is closed brace
                if (!s.empty() && s.peek() == '{') {
                    s.pop();
                } else {
                    s.push(ch);
                }
            }

        }

        int a = 0, b = 0;

        while (!s.empty()) {
            if (s.peek() == '{') {
                a++;
            } else {
                b++;
            }
            s.pop();
        }

        int ans = (a + 1) / 2 + (b + 1) / 2;
        return ans; 

    }

    public static void main(String[] args) {

    }
}
