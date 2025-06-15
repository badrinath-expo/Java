
import java.util.Stack;

public class Ep32_nge {

    public static int[] getNge(int arr[], int n) {
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            while (!st.empty() && curr > arr[st.peek()]) {
                nge[st.peek()] = curr;
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()) {
            nge[st.peek()] = -1;
            st.pop();
        }

        return nge;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 4, 5, 2, 25, 7, 8 };

        int nge[] = getNge(arr, arr.length);

        for(int e: nge){
            System.out.print(e + " ");
        }
        System.out.println();

 
    }
}


//Solve nge II on leetcode
