import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ep61_QueueProblems1 {

    // GFG
    static String firstNonRepeatingCharacterInStream(String s) {
        int count[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // increase count
            count[ch - 'a']++;

            // push to queue
            q.add(ch);

            while (!q.isEmpty()) {
                if (count[q.peek() - 'a'] > 1) {
                    q.remove(); // repeating character
                } else {
                    // non-repeating character
                    ans.append(q.peek()); 
                    break;
                }
            }

            if (q.isEmpty()) {
                ans.append("#");
            }
        }
        return ans.toString();
    } //aabc

    // Reverse Firs k elements of queue
    static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (k > q.size()) { // edge case: found on observing failed test case
            return q;
        }
        // step1: pop first k elements from q and put into stack
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) {
            if (!q.isEmpty()) {
                s.push(q.peek());
                q.remove();
            }
        }
        // step2: fetch from stack and push into q
        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
        }

        if (k >= q.size()) {
            return q;
        }

        int t = q.size() - k;
        while (t > 0) {
            int val = q.peek();
            q.remove();
            q.add(val);
            t--;
        }
        return q;
    } // O(K) + O(N-K) == O(N)

    /*
     * First negative integer in every window of size K:
     * GFG:Optimize the last test case find the optimal approach
     */
    ArrayList<Long> printFirstNegativeInteger(Long A[], long N, int K) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Long> ans = new ArrayList<>();

        // process first window of k size
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                dq.addLast(i);
            }
        }

        // store answer of firs k size window
        if (dq.size() > 0) {
            ans.add(A[dq.getFirst()]);
        } else {
            ans.add(0L);
        }

        // process for remaining window
        for (int i = K; i < N; i++) {
            // removal
            if (!dq.isEmpty() && i - dq.getFirst() >= K) {
                dq.removeFirst();
            }
            // addition
            if (A[i] < 0) {
                dq.addLast(i);
            }

            // ans store
            if (dq.size() > 0) {
                ans.add(A[dq.getFirst()]);
            } else {
                ans.add(0L);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Queue<Integer> input = new LinkedList<>();
        input.add(7);
        input.add(7);
        input.add(5);
        input.add(6);
        input.add(5);
        input.add(10);

        Queue<Integer> q = modifyQueue(input, 8);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
