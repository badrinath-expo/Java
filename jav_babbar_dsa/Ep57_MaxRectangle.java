import java.util.Stack;

public class Ep57_MaxRectangle {

    static void nextSmallerElement(int arr[], int[] nse) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && (arr[i] < arr[st.peek()])) {
                nse[st.peek()] = i; // arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (!st.empty()) {
            nse[st.peek()] = -1;
            st.pop();
        }
    }

    static void prevSmallerElement(int arr[], int[] pse) {

        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && (arr[i] < arr[st.peek()])) {
                pse[st.peek()] = i; // arr[i];
                st.pop();
            }
            st.push(i);
        }

        while (!st.empty()) {
            pse[st.peek()] = -1;
            st.pop();
        }
    }

    static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = new int[n];
        nextSmallerElement(heights, next);

        for (int i = 0; i < n; i++) {
            System.out.print(next[i] + " ");
        }
        System.out.println();

        int[] prev = new int[n];
        prevSmallerElement(heights, prev);

        for (int i = 0; i < n; i++) {
            System.out.print(prev[i] + " ");
        }
        System.out.println();

        int area = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int l = heights[i];

            if (next[i] == -1) {// that means there is no smaller element than this after this index, so set to
                                // last index
                next[i] = n;
            }
            int b = next[i] - prev[i] - 1;

            int newArea = l * b;
            area = Math.max(area, newArea);
        }
        return area;

    }

    static int maxArea(int M[][], int n, int m) {
        int area = largestRectangleArea(M[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] != 0)
                    M[i][j] = M[i][j] + M[i - 1][j];
                else
                    M[i][j] = 0;
            }
            area = Math.max(area, largestRectangleArea(M[0]));
        }
        return area;
    } // O(row*col) S.C - O(m-no.of cols)

    public static void main(String[] args) {

    }
}
