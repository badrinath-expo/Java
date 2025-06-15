import java.util.Arrays;

/*Not working fix on coding ninjas */
class NStacks {
    int arr[];
    int top[];
    int next[];

    int n, s;
    int freespot;

    public NStacks(int N, int S) {
        n = N;
        s = S;
        arr = new int[n];
        top = new int[N];
        next = new int[N];

        Arrays.fill(top, -1);
        for (int i = 0; i < arr.length; i++) {
            next[i] = i + 1;
        }

        next[s - 1] = -1;
        freespot = 0;
    }

    boolean push(int x, int m) { // push x into mth stack
        // check for overflow
        if (freespot == -1) {
            return false;
        }

        // find index
        int index = freespot;

        // update freespot
        freespot = next[index];

        // insert element
        arr[index] = x;

        next[index] = top[m - 1];

        // update top
        top[m - 1] = index;
        return true;

    }

    int pop(int m) {
        if (top[m - 1] == -1)
            return -1;

        int index = top[m - 1];
        top[m - 1] = next[index];
        next[index] = freespot;
        freespot = index;
        return arr[index];
    }

}

public class Ep58_Nstacks {

    public static void main(String[] args) {

    }
}
