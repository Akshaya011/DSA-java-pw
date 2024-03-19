public class CoinChange {
    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int n = coins.length;
        int sum = 10;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = Solution(coins, sum, 0, dp);
        System.out.println(ans);
    }

    public static int Solution(int[] coins, int sum, int idx, int[][] dp) {
        if (sum == 0)
            return 1;
        if (idx == coins.length)
            return 0;
        if (dp[idx][sum] != -1)
            return dp[idx][sum];
        int pick = 0;
        if (sum >= coins[idx])
            pick = Solution(coins, sum - coins[idx], idx, dp);
        int notpick = Solution(coins, sum, idx + 1, dp);

        return dp[idx][sum] = pick + notpick;
    }
   /*  public static int Tabulation_Solution(int[] coins,int sum){
        int n=coins.length;

        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<=sum;i++){

        }
    }
    */
}
