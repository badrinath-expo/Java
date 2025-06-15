import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Ep21_ArraySums {

    static void cyclicRotateArray(int arr[], int k) {
        int n = arr.length;

        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int nextPos = (i + k) % n;
            ans[i] = arr[nextPos];
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

    static boolean checkRotatedSorted(int arr[]) {
        int ct = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                ct++;
            }
        }

        if (arr[arr.length - 1] > arr[0]) {
            ct++;
        }

        return ct == 1;
    }

    static void Add2ArrayedNumbers(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        int i = n - 1;
        int j = m - 1;

        ArrayList<Integer> ans = new ArrayList<>();

        int carry = 0;

        while (i >= 0 && j >= 0) {
            int sum = a[i] + b[j] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
            j--;
        }

        // first case
        while (i >= 0) {
            int sum = a[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
        }

        // second case
        while (j >= 0) {
            int sum = b[j] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            j--;
        }

         Collections.reverse(ans);
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        cyclicRotateArray(new int[] { 1, 7, 9, 11 }, 2); // {9,11,1,7}
        System.out.println(checkRotatedSorted(new int[] { 3, 4, 5, 1, 2 }));

        Add2ArrayedNumbers(new int[] { 4, 5, 1 }, new int[] { 3, 4, 5 });
    }
}

//Co