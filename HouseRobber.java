public class HouseRobber {
    public static void main(String[] args) {
        int nums[]={9,1,3,8};
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        System.out.println(Rob(nums, 0,dp));
    }
    static int Rob(int House[],int idx,int[] dp){
        if(idx==House.length-1)return House[idx];
        if(idx>=House.length)return 0;


        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick=House[idx]+Rob(House, idx+2,dp);
        int notpick=0+Rob(House,idx+1,dp);
        return dp[idx]= Math.max(pick,notpick);
    }
}
