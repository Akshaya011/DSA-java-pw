public class Regeme_Matching {
    public static void main(String[] args) {
        String s="aabbbc";int m=s.length();
        String pattern="c*b.";int n=pattern.length();
        System.out.println(rec(s, pattern, m-1,n-1));
    }
    static boolean rec(String s,String p,int i,int j){
        if(i==-1&&j==-1)return true;
        if(j==-1&& i>=0)return false;
        if(i==-1 && j>=0){
            for(int x=0;x<=j;x++){
                if(p.charAt(x)!='*')return false;
                else continue;
            }
            return true;
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
          return rec(s, p, i-1, j-1);

       else if(p.charAt(j)=='*'){
           return rec(s, p, i, j-1) || rec(s, p, i-1, j);
        }
        return false;
    }
}
