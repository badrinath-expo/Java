public class Ep17_BubbleSort {

    static void bubbleSort(int arr[], int n) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
        bubbleSort(new int[] { 8, 4, 5, 2, 1 }, 5);
    }
}
