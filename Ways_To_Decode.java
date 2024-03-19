public class Ways_To_Decode {
    public static void main(String[] args) {
        String str="11126";
        int dp[]=new int[str.length()];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(ways(str, str.length()-1,dp));
    }
    static int ways(String str,int idx,int[] dp){
        if(idx<=0)return 1;
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int notcombine=0;
        if(str.charAt(idx)!='0'){
            notcombine=ways(str, idx-1,dp);
        }
        int combine=0;
        if(str.charAt(idx-1)=='1' || (str.charAt(idx-1)=='2' && str.charAt(idx)<='6')){
            combine=ways(str, idx-2,dp);
        }
        return dp[idx]= notcombine+combine;
    }
}
