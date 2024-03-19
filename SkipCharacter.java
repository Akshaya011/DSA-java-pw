public class SkipCharacter {
    public static void main(String[] args) {
       Sol("","abcax"); 
    }
    static void Sol(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            Sol(p, up.substring(1));
        }else{
            Sol(p+ch, up.substring(1));            
        }
    }
}
