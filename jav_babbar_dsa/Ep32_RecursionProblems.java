public class Ep32_RecursionProblems {

    int countDistinctWaysToClimbStairs(long nStairs) {

        // base case
        if (nStairs < 0)
            return 0;

        if (nStairs == 0)
            return 1;

        int ans = countDistinctWaysToClimbStairs(nStairs - 1) + countDistinctWaysToClimbStairs(nStairs - 2);

        return ans;
    }

    static boolean isSortedArray(int[] arr, int index) {

        if (index <= 0)
            return true;

        boolean ans;

        if (arr[index] >= arr[index - 1]) {
            ans = true;
        } else {
            ans = false;
        }

        return ans && isSortedArray(arr, index - 1);
    }

    static int getSum(int arr[], int index) {
        if (index < 0) {
            return 0;
        }

        return arr[index] + getSum(arr, index - 1);
    }

    static boolean linearSearch(int arr[], int index, int key) {
        if (index < 0) {
            return false;
        }

        boolean ans = (arr[index] == key);
        ans |= linearSearch(arr, index - 1, key);
        return ans;
    }

    static boolean binarySearch(int arr[], int key, int l, int r) {
        if (l > r)
            return false;

        int mid = l + (r - l) / 2;
        if (key <= arr[mid]) {
            if (arr[mid] == key)
                return true;
            return binarySearch(arr, key, l, mid);
        } else {
            return binarySearch(arr, key, mid + 1, r);
        }

    }

    public static void main(String[] args) {
        System.out.println(isSortedArray(new int[] { 1, 2, 3, 8 }, 3));

        System.out.println(getSum(new int[] { 1, 2, 3, 4 }, 3));
        System.out.println(linearSearch(new int[] { 1, 2, 3, 4 }, 3, 4));
        System.out.println(binarySearch(new int[] { 1, 2, 3, 4 }, 13, 0, 3));
    }
}
