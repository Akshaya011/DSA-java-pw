// import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        List<Integer> profit=List.of(1,2,3);
        List<Integer> weight=List.of(4,5,1);
        int W=4;
        int n=profit.size();
        int[][] dp=new int[n+1][W+1];
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=W;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(Solution(n-1, W, profit, weight,dp));
        System.out.println("using tabulation");
        Tabulation(n-1, W, profit, weight, dp);
        Tabulation2(n-1, W, profit, weight);
    }
    private static int Solution(int idx,int W,List<Integer> profit,List<Integer> weight, int[][] dp){
        if(dp[idx][W]!=-1)return dp[idx][W];
        if(idx==0){
            if(weight.get(0)<= W)return profit.get(0);
            else return 0;
        }

        int pick=0;
        if(W>=weight.get(idx))
            pick=profit.get(idx)+Solution(idx-1, W-weight.get(idx), profit, weight,dp);
        int notpick=Solution(idx-1, W, profit, weight,dp);

        return dp[idx][W]= Math.max(pick, notpick);
    }
    private static void Tabulation(int idx,int W,List<Integer> profit,List<Integer> weight, int[][] dp){
        for(int i=0;i<=W;i++){
            if(i>=weight.get(0))dp[0][i]=profit.get(0);
            else dp[0][i]=0;
        }
        for(int i=1;i<profit.size() ; i++){
            for(int w=0;w<=W;w++){
                int pick=0;
                if(w>=weight.get(i))pick=profit.get(i)+dp[i-1][w-weight.get(i)];
                int notpicked=dp[i-1][w];

                dp[i][w]= Math.max(pick,notpicked);
            }
        }
        System.out.println(dp[profit.size()-1][W]);
    }
    private static void Tabulation2(int idx,int W,List<Integer> profit,List<Integer> weight){
        int n=profit.size();
        int prev[]=new int[W+1];
        int current[]=new int[W+1];
        for(int i=0;i<=W;i++){
            if(i>=weight.get(0))prev[i]=1;
            else prev[i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                int pick=0;
                if(j>=weight.get(i))pick=profit.get(i)+prev[j-weight.get(i)];
                int notpicked=prev[j];

                current[j]=Math.max(pick, notpicked);
            }
            System.arraycopy(current,0,prev,0,W+1);
        }
        System.out.println(prev[W]);
    }
    
}
