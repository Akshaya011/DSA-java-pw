public class Lec87_Number_of_Square_Submatrices {
    public static void main(String[] args) {
        int matrix[][]={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        // int matrix[][]={{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};

        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){dp[i][j]=matrix[i][j];continue;}
                
                int up=i-1>=0?dp[i-1][j]:0;
                int left=j-1>=0?dp[i][j-1]:0;
                int upleft=i-1>=0 && j-1>=0?dp[i-1][j-1]:0;
                dp[i][j]=matrix[i][j]==0?0:matrix[i][j]+Math.min(up,Math.min(left,upleft));
            }
        }
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
                ans+=dp[i][j];
            }
            System.out.println();
        }
        System.out.println(ans);
        System.out.println(Solution(matrix));
    }
    static int Solution(int matrix[][]){
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==1 && i>0 && j>0){
                    matrix[i][j]=1+Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                }
                ans+=matrix[i][j];
            }
        }
        return ans;
    }
    
}
