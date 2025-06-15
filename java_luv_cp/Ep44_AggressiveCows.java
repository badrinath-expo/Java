import java.util.Arrays;

public class Ep44_AggressiveCows {

    public static boolean isCowsPlaced(int[] positions, int dist, int cows) {
        int lastPos = positions[0];
        cows--;

        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPos >= dist) {
                lastPos = positions[i];
                cows--;
                if (cows == 0)
                    return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] nums, int k) {

        int r = (int) 1e9;
        int l = 0;
        int ans = -1;
        Arrays.sort(nums);
        while (r >= l) {
            int mid = l + (r - l) / 2;

            if (isCowsPlaced(nums, mid, k)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int stalls[] = { 1, 2, 4, 8, 9 };
        int k = 3;
        int res = aggressiveCows(stalls, k);
        System.out.println(res); // Output: 3
    }
}
