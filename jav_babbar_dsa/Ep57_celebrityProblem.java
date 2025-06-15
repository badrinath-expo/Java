import java.util.Stack;

public class Ep57_celebrityProblem {

    static int celebrity(int[][] M, int n) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() != 1) {
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();

            if (M[a][b] != 1) {
                s.push(a);
            }

            if (M[b][a] != 1) {
                s.push(b);
            }
        }

        // verify

        int currCelbrity = s.peek();

        for (int i = 0; i < n; i++) {
            if (currCelbrity != i) {
                if (M[currCelbrity][i] != 0 || M[i][currCelbrity] != 1) {
                    return -1;
                }
            }
        }

        return currCelbrity;

    }

    static int celebrity(int[][] mat) {
        int n = mat.length;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();

            if (mat[a][b] == 1) {
                s.push(b); //a knows b. so a can't be a celebrity
            }else{
                s.push(a);
            }
        }

        // verify
        int currCelbrity = s.peek();
        for (int i = 0; i < n; i++) {
            if (currCelbrity != i) {
                if (mat[currCelbrity][i] != 0 || mat[i][currCelbrity] != 1) {
                    return -1;
                }
            }
        }

        return currCelbrity;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };

        System.out.println(celebrity(M, 3));
    }
}
