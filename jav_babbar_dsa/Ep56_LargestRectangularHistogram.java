import java.util.ArrayList;
import java.util.Stack;

public class Ep56_LargestRectangularHistogram {

    static void nextSmallerElement(int arr[], int[] nse) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && (arr[i] < arr[st.peek()])) {
                nse[st.peek()] = i; //arr[i];
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
                pse[st.peek()] = i; //arr[i];
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

    } //T.C - O(N)     S.C - O(N)

    public static void main(String[] args) {

        int arr[] = new int[] { 2, 3, 1 };

        int nge[] = new int[arr.length];

        // findNge(arr, nge);

        // for (int i = 0; i < nge.length; i++) {
        // System.out.print(nge[i] + " ");
        // }
        // System.out.println();

        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }
}
