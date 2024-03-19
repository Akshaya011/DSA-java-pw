import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partioning {
    public static void main(String[] args) {
        String s="aababa";
        List<List<String>> ans=new ArrayList<>();
        List<String> list=new ArrayList<>();

        System.out.println("list of string after partitioning : \n");
        rec(s, 0,ans,list);
        System.out.println(ans);
    }
    static void rec(String s,int idx,List<List<String>> ans,List<String> list){
    if(idx==s.length()){
        ans.add(new ArrayList<>(list));
        return;
    }
        for(int i=idx;i<s.length();i++){
            String temp=s.substring(idx,i+1) ;
            if(ispalin(temp)){
                list.add(temp);
                rec(s, i+1, ans, list);
                list.remove(list.size()-1);
            }
        }
    }
    static boolean ispalin(String a){
        int i=0,j=a.length()-1;
        while(i<j){
            if(a.charAt(i++)!=a.charAt(j--))return false;
        }
        return true;
    }
}
