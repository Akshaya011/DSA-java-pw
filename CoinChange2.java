public class CoinChange2 {
   public static void ConstantSpaceSol(int[] coins,int totalsum){
        int n=coins.length;
        int current[]=new int[totalsum+1];
        int prev[]=new int[totalsum+1];
        for(int i=0;i<=totalsum;i++){
            current[i]=0;
            if(i%coins[0]==0)prev[i]=1;
            else prev[i]=0;
        }

        for(int i=1;i<n;i++){
            for(int s=0;s<=totalsum;s++){
                int pick=0;
                if(s>=coins[i])pick=current[s-coins[i]];
                int notpick=prev[s];

                current[s]=pick+notpick;
            }
            prev=current;
        }
        System.out.println(current[current.length-1]);
    }
    public static void main(String[] args) {
        int coins[]={2,5,3,6};
        int n=coins.length;
        int sum=10;
        int dp[][] = new int[n + 1][sum + 1];
       /* for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        } */
        for(int i=0;i<=sum;i++){
            if(i%coins[0]==0)dp[0][i]=1;
            else dp[0][i]=0;
        }
        for(int idx=1;idx<n;idx++){
            for(int s=0;s<=sum;s++){
                int pick=0;
                if(s>=coins[idx])pick=dp[idx][s-coins[idx]];
                int notpick=dp[idx-1][s];

                dp[idx][s]=pick+notpick;
            }
        }
        // int ans = Solution(coins, sum, n-1, dp);
        // System.out.println(ans);
        System.out.println(dp[n-1][sum]);
        ConstantSpaceSol(coins,sum);
    }
    static int Solution(int[] coins, int sum, int idx, int[][] dp){
        if(idx==0){
            if(sum%coins[idx]==0)return 1;
            else return 0;
        }
        if(sum==0)return 1;
        if(dp[idx][sum]!=-1)return dp[idx][sum];
        int pick=0;
        if(sum>=coins[idx]){
            pick=Solution(coins, sum-coins[idx], idx, dp);
        }
        int notpick=Solution(coins, sum, idx-1, dp);
        return dp[idx][sum]= pick+notpick;
    }
}
