public class Ep13_BinSearchProblems {

    static int binarySearch(int arr[], int key) {
        int l = 0, r = arr.length - 1;

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

    static int binarySearchTest(int arr[], int key) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2; // (l+r)/2 overflows for greater integer values

            if (arr[mid] == key)
                return mid;
            if (key >= arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    static int firstOccurence(int arr[], int key) {
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // (l+r)/2 overflows for greater integer values

            // if (arr[mid] == key) { //here also we can add
            // ans = mid;
            // }
            if (key <= arr[mid]) {
                if (arr[mid] == key) {
                    ans = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;

    }

    static int lastOccurence(int arr[], int key) {
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // (l+r)/2 overflows for greater integer values

            if (key < arr[mid]) {
                r = mid - 1;
            } else {
                if (arr[mid] == key)
                    ans = mid;
                l = mid + 1;
            }
        }

        return ans;
    }

    // total no.of times an element occured is = lastOcc - firstOcc + 1

    // Peak
    // Brute force:max element in the array is the peak
    static int findPeak(int arr[]) {
        int l = 0, r = arr.length - 1;

        int mid = -1;

        while (l < r) {
            mid = l + (r - l) / 2;

            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return mid;

    }

    public static void main(String[] args) {
        System.out.println(firstOccurence(new int[] { 1, 2, 2, 2, 8, 10, 14, 18 }, 2));
        System.out.println(lastOccurence(new int[] { 1, 2, 2, 2, 8, 10, 14, 18 }, 2));
        System.out.println(findPeak(new int[] { 3, 4, 5, 1 }));

        System.out.println(binarySearchTest(new int[] { 10, 13, 18, 29 }, 13));

    }
}
