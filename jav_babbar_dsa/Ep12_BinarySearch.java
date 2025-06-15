public class Ep12_BinarySearch {

    static int binarySearch(int arr[], int key) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2; //(l+r)/2 overflows for greater integer values

            if (arr[mid] == key)
                return mid;
            if (key <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    } //O(log N base 2)

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { 1, 5, 8, 10, 14, 18 }, 18));
    }
}
