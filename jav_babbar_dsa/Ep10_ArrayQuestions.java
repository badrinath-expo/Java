import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ep10_ArrayQuestions {

    static void swapAlternate() {
        int arr[] = { 5, 2, 9, 4, 7, 6, 1, 0 };

        for (int i = 0; i < arr.length; i += 2) {
            if (i + 1 < arr.length) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static ArrayList<Integer> arrayIntersection() {
        int arr1[] = { 3, 4, 6 };
        int[] arr2 = {};

        int n = arr1.length, m = arr2.length;

        int i = 0, j = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                ans.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }

        }

        return ans;

    }

    static void pairSum(int arr[], int s) {

        List<ArrayList<Integer>> answers = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(Math.min(arr[i], arr[j]));
                    ans.add(Math.max(arr[i], arr[j]));
                    answers.add(ans);
                }
            }
        }

        answers.sort((a, b) -> a.get(0) - b.get(0));

        for (ArrayList<Integer> a : answers) {
            for (Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void sort10(int arr[]) {

        int i = 0;
        int j = arr.length - 1;

        while (i != j) {

            while (arr[i] == 0 && i < j) {
                i++;
            }

            while (arr[j] == 1 && i < j) {
                j--;
            }

            // (arr[i] == 1 && arr[j] == 0)
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }

        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        pairSum(new int[] { 2, -3, 3, 3, -2 }, 0);

        sort10(new int[] { 0, 1, 0, 1, 1, 0 });

    }
}
