import java.util.Map;
import java.util.Stack;

public class Ep31_balanced_parenthesis {

    public static boolean isBalanced(String input, Map<Character, Integer> symbols) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
             if(symbols.get(input.charAt(i)) < 0){
                st.push(input.charAt(i));
             }else{
                if(!st.empty() && ((symbols.get(st.peek()) + symbols.get(input.charAt(i)) == 0))){
                  st.pop();
                }else{
                    return false;
                }
             }
        }

        return st.empty();
    }

    public static void main(String[] args) {
        Map<Character, Integer> symbols = Map.of(
                '[', -1,
                ']', 1,
                '(', -2,
                ')', 2,
                '{', -3,
                '}', 3
        );

        String input = "{[(])}";
        System.out.println(isBalanced(input, symbols));
    }
}
