import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        String str="31355";
        List<Integer> frequency=new ArrayList<>();
        for(int i=0;i<10;i++){
            frequency.add(0);
        }
        for(int i=0;i<str.length();i++){
            int a=str.charAt(i)-'0';
            frequency.set(a, frequency.get(a)+1);
            
        }
        if(!validate(frequency)){
            System.out.println("not a palindrome..");return;
        }
        String firststring="";
        for(int i=9;i>=0;i--){
            
            while(frequency.get(i)>1){
                firststring+=i;
                frequency.set(i, frequency.get(i)-2);
            }
        }
        StringBuilder sb=new StringBuilder(firststring);
        sb.reverse();
        String laststring=sb.toString();
        for(int i=0;i<10;i++){
            if(frequency.get(i)==1)firststring+=i;
        }
        String ans=firststring+laststring;
        System.out.println(ans);
    }
   public static boolean validate(List<Integer> frq){
        boolean odd=false;
        for(int i:frq){
            if(i%2!=0){
                if(odd==false)odd=true;
                else return false;
            }
        }
        return true;
    }
}
