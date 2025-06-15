public class Ep15_BookAllocation {

    static boolean isPossible(int arr[], int n, int students, int mid) {
        int studentCt = 1;
        int pageSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                studentCt++;
                if (studentCt > students || arr[i] > mid) { // select mid no.of pages are less < arr's ith index book's pages
                    return false;
                }
                pageSum = arr[i];
            }
        }

        return true;
    }

    static int allocateBooks(int[] arr, int n, int m) {
        int s = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int e = sum;

        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1; // we are going left since we need minimun
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(allocateBooks(new int[] { 12, 34, 67, 90 }, 4, 2)); // 113
    }
}
