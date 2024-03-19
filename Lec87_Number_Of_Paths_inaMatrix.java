import java.util.Arrays;
// p&c formula (m+n-2)!/(m-1)!*(n-1)!        ***************
public class Lec87_Number_Of_Paths_inaMatrix {
    public static void main(String[] args) {
        int m=2,n=3;
        System.out.println(rec(m-1,n-1));
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        System.out.println(memo(m, n, dp));
        System.out.println(tabulation(m, n));
    }

    private static int tabulation(int m,int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        // dp[1][1]=1;        
        
        for (int i = 1; i <dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    private static int memo( int i, int j,int[][] dp) {
        if(i==0||j==0)return dp[i][j]= 0;
        if(i==1 && j==1)return dp[i][j]=1;        
        
        return dp[i][j]= memo(i,j-1,dp)+ memo(i-1,j,dp);
    }
    private static int rec( int i, int j) {
        if(i==0&&j==0)return 1;
        if(i<0 || j<0)return 0;
        
        
        return rec(i,j-1)+ rec(i-1,j);
    }
}
