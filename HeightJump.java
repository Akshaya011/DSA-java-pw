import java.util.ArrayList;
import java.util.List;

public class HeightJump {
    public static void main(String[] args) {
        int height[] = { 10, 30, 40, 50, 20 };
        // int height[] = { 10, 20, 10 };
        int dp[] = new int[height.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;

        // System.out.println("height jump : " + rec(height, 4));
        System.out.println("Solution for k jump : " + Solutionfor_k(height, 0, 3, dp));
        System.out.println("Tabulation for k jump : "  );
        Tabulation(height, 3);
        System.out.println("Tabulation2 result for k jump : "  );
        Tabulation2(height, 3);
    }

    private static int rec(int height[], int idx) {
        // if(idx==height.length-1)return 0;
        if (idx == 0)
            return 0;

        int jump2 = 100;

        int jump1 = Math.abs(height[idx] - height[idx - 1]) + rec(height, idx - 1);
        if (idx > 1)
            jump2 = Math.abs(height[idx] - height[idx - 2]) + rec(height, idx - 2);

        return Math.min(jump1, jump2);
    }

    private static int Solutionfor_k(int[] height, int idx, int k, int dp[]) {
        if (idx == height.length - 1)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int mincost = 1000;
        for (int i = 1; i <= k; i++) {
            if (idx + i < height.length) {
                int jump = Math.abs(height[idx] - height[idx + i]) + Solutionfor_k(height, idx + i, k, dp);
                mincost = Math.min(mincost, jump);
            }
        }
        return dp[idx] = mincost;
    }

    private static void Tabulation(int[] height,int k){
            int n=height.length;
            int dp[]=new int[n];
            dp[0]=0;
            for(int i=1;i<n;i++){
                int mincost=1000;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump=Math.abs(height[i]-height[i-j])+dp[i-j];
                mincost=Math.min(mincost,jump);
                }
            }
            dp[i]=mincost;
        }
        System.out.println(dp[n-1]);
    }
    private static void Tabulation2(int[] height,int k){
            int n=height.length;
            List<Integer> dp=new ArrayList<>();
            dp.add(0);

            for(int i=1;i<n;i++){
                int mincost=1000;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump=Math.abs(height[i]-height[i-j])+dp.get(dp.size()-j);
                mincost=Math.min(mincost,jump);
                }
            }
            if(dp.size()==k){
                dp.remove(0);
            }
            dp.add(mincost);
        }
        System.out.println(dp.get(k-1));
    }
}
