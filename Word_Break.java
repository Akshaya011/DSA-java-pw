import java.util.Arrays;

public class Word_Break {
    public static void main(String[] args) {
        String s="applepenapple";
        String[] wordDict={"apple","pen"};
        int n=wordDict.length;
        System.out.println(rec(s, wordDict, 0));
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        System.out.println(memo(s, wordDict, n, dp));
    }
    static boolean memo(String s,String dict[],int idx,int[] dp){
        if(dp[idx]==-1)return dp[idx];
        if(idx==s.length())return true;
        for(int i=idx;i<s.length();i++){
            String temp=s.substring(idx, i+1);
            if(isvalidcut(temp, dict)){
                if(rec(s, dict, i+1)){
                    dp[idx]=1;
                    return true;
                }else dp[idx]=0;
            }
        }
        return false;
    }
    static boolean rec(String s,String dict[],int idx){
        if(idx==s.length())return true;
        for(int i=idx;i<s.length();i++){
            String temp=s.substring(idx, i+1);
            if(isvalidcut(temp, dict)){
               return rec(s, dict, i+1);
            }
        }
        return false;
    }
    static boolean isvalidcut(String a,String dict[]){
        for(int i=0;i<dict.length;i++){
            if(dict[i].equals(a))return true;
        }
        return false;
    }
}
