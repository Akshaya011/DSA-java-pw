import java.util.Arrays;
import java.util.List;

public class Matrix_Chain_Multiplication {
  public static void main(String[] args) {
    // List<Integer> arr=List.of(40,20,30,10,30);
    List<Integer> arr = List.of(1, 2, 3, 4, 3);
    int n = arr.size();
    int dp[][] = new int[n][n];
    for (int i = 0; i < dp.length; i++)
      Arrays.fill(dp[i], -1);
    System.out.println("recursion - result : "+rec(1, n - 1, arr));
    System.out.println("memoization result : "+memo(1, n - 1, arr, dp));
    tabulation(arr);
  }

  private static int rec(int i, int j, List<Integer> arr) {
    if (i == j)
      return 0;
    int min = 999999;
    for (int k = i; k < j; k++) {
      int ans = rec(i, k, arr) + rec(k + 1, j, arr) + arr.get(i - 1) * arr.get(k) * arr.get(j);
      min = Math.min(min, ans);
    }
    return min;
  }

  private static int memo(int i, int j, List<Integer> arr, int[][] dp) {
    if (i == j)
      return dp[i][j] = 0;
    int min = 999999;
    for (int k = i; k < j; k++) {
      int ans = memo(i, k, arr, dp) + memo(k + 1, j, arr, dp) + arr.get(i - 1) * arr.get(k) * arr.get(j);
      min = Math.min(min, ans);
    }
    return dp[i][j] = min;
  }

  private static void tabulation(List<Integer> arr) {
    int n = arr.size();
    int dp[][] = new int[n][n];
    for (int i = 0; i < dp.length; i++)
      dp[i][i] = 0;

    for (int i = n - 1; i >= 1; i--) {
      for (int j = i + 1; j < n; j++) {
        int min = 999999;
        for (int k = i; k < j; k++) {
          int ans = dp[i][k] + dp[k + 1][j] + arr.get(i - 1) * arr.get(k) * arr.get(j);
          min = Math.min(min, ans);
        }
         dp[i][j] = min;
      }
    }
    System.out.println("tabulation ans : "+dp[1][n-1]);
  }
}
