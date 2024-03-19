// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int a=helper("","ecbaddce",3);
        System.out.println(a);
    }
    static int helper(String p, String up,int K){
       if(up.isEmpty()){
           int a=0;Set<Character> st=new HashSet<>();
           for(int i=0;i<p.length();i++){
               if(!st.contains(p.charAt(i))){
                   st.add(p.charAt(i));
               }
           }
           if(st.size()==K) {
               System.out.println(p);
               return 1;
           }
           else return 0;
       }
       int count=0;
       char ch=up.charAt(0);
      int left=count+ helper(p,up.substring(1),K);
      int right=count+ helper(p+ch,up.substring(1),K);
      return left+right;
   }
}