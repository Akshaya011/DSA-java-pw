import java.util.Arrays;

public class Lec87_Minimum_PathSum {
    public static void main(String[] args) {
        int matrix[][]={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(rec(matrix, 0, 0));
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println("memoization result-:"+memo(matrix, 0, 0, dp));
        System.out.println("tabulation result-:"+tabulation(matrix));
    }
   static int memo(int[][] matrix,int i,int j,int dp[][]){
       if(i==matrix.length-1 && j==matrix[i].length-1)return dp[i][j]= matrix[i][j];
       if(i==matrix.length || j==matrix[i].length)return Integer.MAX_VALUE;
       if(dp[i][j]!=-1)return dp[i][j];
        
        int right= memo(matrix, i, j+1,dp);
        int down= memo(matrix, i+1, j,dp);
        return dp[i][j]= matrix[i][j] + Math.min(right,down);
    }
   static int tabulation(int[][] matrix){
       int dp[][]=new int[matrix.length][matrix[0].length];
       
       for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
            if(i==0 && j==0) {dp[i][j]= matrix[i][j];continue;}
            
                int down=i-1>=0?dp[i-1][j]:Integer.MAX_VALUE;
                int right=j-1>=0?dp[i][j-1]:Integer.MAX_VALUE;
                dp[i][j]=matrix[i][j]+Math.min(down,right);
             }    
        
       }
       return dp[dp.length-1][dp[0].length-1];
    }
   static int rec(int[][] matrix,int i,int j){
        if(i==matrix.length-1 && j==matrix[i].length-1)return matrix[i][j];
        if(i==matrix.length || j==matrix[i].length)return Integer.MAX_VALUE;
        
        int right= rec(matrix, i, j+1);
        int down= rec(matrix, i+1, j);
        return matrix[i][j] + Math.min(right,down);
    }
}
