public class Ep19_MergeSort {

    public static int[] mergeSort(int arr[], int l, int r) {
        if (l == r) {
            return new int[] { arr[l] };
        }
        int mid = (l + r) / 2;
        int left[] = mergeSort(arr, l, mid);
        int right[] = mergeSort(arr, mid + 1, r);
        return merge(left, right);
    }

    public static int[] merge(int left[], int right[]) {
        int mergedArray[] = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mergedArray[k++] = left[i++];
            } else {
                mergedArray[k++] = right[j++];
            }
        }

        while (i < left.length) {
            mergedArray[k++] = left[i++];
        }

        while (j < right.length) {
            mergedArray[k++] = right[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 7, 8, 4, 4, 3, 2 };

        arr = mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

}
