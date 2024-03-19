public class SumwithAlternateSigns {
    public static void main(String[] args) {
        System.out.println(sum(6));
    }
    static int sum(int n){
        if(n == 0){
            return 0;
        }if( n%2 ==0){
            return sum(n-1)-n;
        }
        return sum(n-1)+n;
    }
}
