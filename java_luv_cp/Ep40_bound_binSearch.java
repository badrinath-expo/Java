public class Ep40_bound_binSearch {

    public static int uBound(int arr[], int key) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (key < arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return arr[l];
    }

    public static int lowerBound(int arr[], int key) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (key <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return arr[l];
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 2, 4, 5, 6 };

        int uBound = uBound(arr, 2);

        int lowerBound = lowerBound(arr, 2);

        System.out.println("lower bound " + lowerBound + " upper bound " + uBound);
    }

}
