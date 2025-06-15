public class Ep14_BinSearchProblems {

    static int getPivot(int arr[], int n) {
        int s = 0, e = n - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    static int binarySearch(int arr[], int l, int r, int key) {
        // int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2; // (l+r)/2 overflows for greater integer values

            if (arr[mid] == key)
                return mid;
            if (key <= arr[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    static int searchInRotatedSortedArray(int[] arr, int n, int key) {
        int pivot = getPivot(arr, n);

        if (key >= arr[pivot] && key <= arr[n - 1]) {
            return binarySearch(arr, pivot, n - 1, key);
        } else {
            return binarySearch(arr, 0, pivot - 1, key);
        }
    }

    static int sqrt(int num) {

        int l = 0, r = num;

        int ans = 0;
        while (l < r) {
            int mid = l + (r - l) / 2; // make mid and ans long if overflows

            if ((mid * mid) <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return ans;
    }

    static double eps = 1e-6; // 10^-6 // Here we kept 10^-6 which gives accuracy of 5 digits

    static double multiply(double mid, int n) { // if nth root
        double ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= mid;
        }
        return ans;
    }

    static double morePrecisionSqrt(double x) {
        double low = 1, high = x, mid;
        while (high - low > eps) {
            mid = (high + low) / 2;
            if ((mid * mid) <= x) { // at mid*mid to get nth root if(mulitply(mid,n))
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(getPivot(new int[] { 3, 8, 10, 17, 1 }, 5));
        System.out.println(searchInRotatedSortedArray(new int[] { 3, 8, 10, 17, 1 }, 5, 17));
        System.out.println(sqrt(36));

        System.out.println(morePrecisionSqrt(4));
    }
}
