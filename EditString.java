import java.util.Arrays;

public class EditString {
    public static void main(String[] args) {
        String a="sunday";
        String b="saturday";
        int dp[][]=new int[a.length()+1][b.length()+1];
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i], -1);
        System.out.println("minimum operation to edit string "+a+" to "+b+" is \n");
        System.out.println("recursion - result : "+rec(a, b, a.length()-1, b.length()-1));
        System.out.println("memoization result : "+memo(a, b, a.length(), b.length(),dp));
        // System.out.println(rec("cat","cut", 2,2));
        System.out.println("tabulation  result : "+ tabulation(a, b));
    }
    private static int tabulation(String a,String b){
        int dp[][]=new int[a.length()+1][b.length()+1];
        for(int i=0;i<dp[0].length;i++)dp[0][i]=i;
        for(int i=0;i<dp.length;i++)dp[i][0]=i;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                    continue;
                }
                int insert=1 + dp[i][j-1];
                int delete=1 + dp[i-1][j];
                int replace=1 + dp[i-1][j-1];

                dp[i][j]= Math.min(insert,Math.min(delete,replace));
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    private static int memo(String a,String b,int i,int j,int dp[][]){
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==0)return dp[i][j]=j;
        if(j==0)return dp[i][j]=i;

        if(a.charAt(i-1)==b.charAt(j-1))return dp[i][j]= memo(a,b,i-1,j-1,dp);

        int insert=1 + memo(a,b,i,j-1,dp);
        int delete=1 + memo(a,b,i-1,j,dp);
        int replace=1 + memo(a,b,i-1,j-1,dp);

        return dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
    private static int rec(String a,String b,int i,int j){
        if(i==-1)return j+1;
        if(j==-1)return i+1;

        if(a.charAt(i)==b.charAt(j))return rec(a, b, i-1, j-1);

        int insert=1 + rec(a,b,i,j-1);
        int delete=1 + rec(a,b,i-1,j);
        int replace=1 + rec(a,b,i-1,j-1);

        return Math.min(insert,Math.min(delete,replace));
    }
}
