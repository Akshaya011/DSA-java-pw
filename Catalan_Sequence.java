import java.util.Arrays;

public class Catalan_Sequence {
    static int catalan(int n,int[] dp){
        int ans=0;
        if(dp[n]!=-1)return dp[n];
        if(n==1||n==0)return dp[n]= 1;
        
        for(int i=0;i<n;i++){
            ans+=catalan(i,dp)*catalan(n-1-i,dp);
        }
        return dp[n]= ans;
    }
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalan(n,dp));
        System.out.println(tabulation(n));
    }

    static int tabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;dp[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
