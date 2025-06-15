import java.util.Arrays;

public class Ep98_Subset_Sum {

    static int dp[][] = new int[205][20005]; /*
                                              * 1<=nums.length<=200
                                              * 1<=nums[i]<=100
                                              */

    static boolean checkSubsetSum(int[] arr, int sum, int index) {
        if (sum == 0)
            return true;
        if (index < 0)
            return false;

        if (dp[index][sum] != -1)
            return dp[index][sum] == 1;

        boolean ans = checkSubsetSum(arr, sum, index - 1); //not considering element at index

        if (sum - arr[index] >= 0) {
            ans |= checkSubsetSum(arr, sum - arr[index], index - 1);// considering element at index
        }

        dp[index][sum] = (ans ? 1 : 0);
        return ans;
    }

    static boolean canPartition(int nums[]) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) { //if sum is odd, we can't divide into 2 equal sums
            return false;
        }
        sum /= 2;

        return checkSubsetSum(nums, sum, nums.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 11, 5 };

        System.out.println(checkSubsetSum(arr, 6, arr.length - 1));
        System.out.println(canPartition(arr));
    }
}
