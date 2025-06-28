import java.util.Arrays;

public class Ep110_01Knapsack {
  static int solve(int[] weight, int[] value, int index, int capacity) {

    if (index >= value.length || capacity <= 0) {
      return 0;
    }

    int ans = 0 + solve(weight, value, index + 1, capacity);
    if (capacity - weight[index] >= 0) {
      ans = Math.max(ans, value[index] + solve(weight, value, index + 1, capacity - weight[index]));
    }
    return ans;
  }

  static int solveMem(int[] weight, int[] value, int index, int capacity, int dp[][]) {

    if (index >= value.length || capacity <= 0) {
      return dp[index][capacity] = 0;
    }

    if (dp[index][capacity] != -1) {
      return dp[index][capacity];
    }
    int ans = 0 + solveMem(weight, value, index + 1, capacity, dp);
    if (capacity - weight[index] >= 0) {
      ans = Math.max(ans, value[index] + solveMem(weight, value, index + 1, capacity - weight[index], dp));
    }
    return dp[index][capacity] = ans;
  }

static int solveTab(int[] weight, int[] value, int n, int capacity) {
    int[][] dp = new int[100][100000];
    for (int w = weight[0]; w <= capacity; w++) {
      if (weight[0] <= capacity) {
        dp[0][w] = value[0];
      } else {
        dp[0][w] = 0;
      }
    }

    for (int i = 1; i < n; i++) {

      for (int w = 0; w <= capacity; w++) {
        int ans = dp[i - 1][w];
        if (w - weight[i] >= 0) {
          ans = Math.max(ans, value[i] + dp[i - 1][w - weight[i]]);
        }
        dp[i][w] = ans;
      }
    }
    return dp[n - 1][capacity];
  }

  static int spaceOptimized(int[] weight, int[] value, int n, int capacity) {
    int prev[] = new int[capacity + 1];
    int curr[] = new int[capacity + 1];

    for (int w = weight[0]; w <= capacity; w++) {
      if (weight[0] <= capacity) {
        prev[w] = value[0];
      } else {
        prev[w] = 0;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int w = 0; w <= capacity; w++) {
        int ans = prev[w];
        if (weight[i] <= w) {
          ans = Math.max(ans, value[i] + prev[w - weight[i]]);
        }
        curr[w] = ans; 
      }

      for (int j = 0; j < curr.length; j++) {
        prev[j] = curr[j]; 
      }
    }
    return prev[capacity];
  }

    static int singeArrayApproach(int[] weight, int[] value, int n, int capacity) {
    int curr[] = new int[capacity + 1];

    for (int w = weight[0]; w <= capacity; w++) {
      if (weight[0] <= capacity) {
        curr[w] = value[0];
      } else {
        curr[w] = 0;
      }
    }
    
    for (int i = 1; i < n; i++) {
      for (int w = capacity; w >= 0; w--) { //right to left, wirte 2 arrays from previous aproach
        int ans = curr[w];
        if (weight[i] <= w) {
          ans = Math.max(ans, value[i] + curr[w - weight[i]]);
        }
        curr[w] = ans; 
      }
    }
    return curr[capacity];
  }

  static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    // return solve(weight, value, 0, maxWeight);
    int[][] dp = new int[100][100000];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveMem(weight, value, 0, maxWeight, dp);
  }

  public static void main(String[] args) {

  }
}
