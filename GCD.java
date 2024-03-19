public class GCD {
    public static void main(String[] args) {
        // System.out.println(LDM(24, 18));
        System.out.println(gcd(20, 16));
        System.out.println(LCM(20, 16));
    }
    static int LDM(int x,int y){
        while(x%y != 0){
            int rem = x % y;
            x=y;
            y=rem;
        }
        return y;
    }
    static int gcd(int x,int y){
        if(x%y == 0){
            return y;
        }
        return gcd(y,x%y);
    }
    static int LCM(int x,int y){
        return x*y/gcd(x, y);
    }
}
