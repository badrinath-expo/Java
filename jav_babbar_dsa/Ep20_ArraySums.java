import java.util.ArrayList;

public class Ep20_ArraySums {

    static void reverseArray(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void merge2SortedArrays(int arr1[], int arr2[]) {

        int i = 0;
        int j = 0;
        int m = arr1.length;
        int n = arr2.length;

        ArrayList<Integer> ans = new ArrayList<>();
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i]);
                i++;
            } else {
                ans.add(arr2[j]);
                j++;
            }
        }

        while (i < m) {
            ans.add(arr1[i]);
            i++;
        }
        while (j < n) {
            ans.add(arr2[j]);
            j++;
        }

        for (int k : ans) {
            System.out.print(k + " ");
        }

        System.out.println();
    }

    static void moveZeros(int arr[]) {
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        reverseArray(new int[] { 4, 3, 2, 1 });
        merge2SortedArrays(new int[] { 1, 3, 5 }, new int[] { 2, 3, 8 });

        moveZeros(new int[] { 2, 0, 1, 3, 0, 0, 0 });
    }
}
