public class FibonacciTabulation {
    public static void main(String[] args) {
        int n=100;
        // int dp[]=new int[n+1];
        // for(int i=0;i<n+1;i++){
        //     dp[i]=-1;
        // }
        // dp[1]=1;
        // dp[2]=1;
        // for(int i=3;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // System.out.println(dp[n]);


        //space optimisation
        long prev1=1;
        long prev2=1;
        long current=0;
        for(int i=3;i<=n;i++){
            current=prev1+prev2;
            prev1=prev2;
            prev2=current;
        }
        System.out.println(current);
    }
}
