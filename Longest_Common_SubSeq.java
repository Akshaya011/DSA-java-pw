public class Longest_Common_SubSeq {
    public static void main(String[] args) {
        String a="SUNDAY"; 
        String b="SATURDAY";  
        int m=a.length();
        int n=b.length();
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println("using memoization : "+rec(a, b, m-1, n-1,dp));
        System.out.println("using tabulation : "+Tabulation(a, b));
        space_Optimize(a,b);
    }
    private static int rec(String a,String b,int i,int j,int[][] dp){ //memoization
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
        return dp[i][j]= 1+ rec(a, b, i-1,j-1,dp);
        
        else return dp[i][j]= Math.max(rec(a, b, i-1, j,dp),rec(a,b,i,j-1,dp));
        
    }
    private static int Tabulation(String a,String b){
        int m=a.length();
        int n=b.length();
        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    // space optimization 
    private static void space_Optimize(String a,String b){
        int m=a.length();
        int n=b.length();

        int current[]=new int[n+1];
        int prev[]=new int[n+1];
        for(int i=0;i<=n;i++){
            prev[i]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                current[j]=1+prev[j-1];
                else current[j]=Math.max(current[j-1],prev[j]);
            }
            prev=current;
        }
        int lcslength=prev[n];
        // operations include only insert and remove one character only at a time.
        int min_operation= a.length()-lcslength+b.length()-lcslength;

        System.out.println("using space optimization : "+prev[n]);
        System.out.println("minimum operation ot edit string a to b : "+min_operation);
    }
}
