public class Ep18_InsertionSort {

    static void insertionSort(int arr[], int n) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    // shift
                    arr[j + 1] = arr[j];

                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        insertionSort(new int[] { 8, 4, 5, 2, 1 }, 5);
    }
}
