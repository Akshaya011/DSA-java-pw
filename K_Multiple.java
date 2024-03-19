public class K_Multiple {
    public static void main(String[] args) {
        // Sol(3, 5);
        System.out.println(Sol(4, 5));
        // Sol2(4, 5);
    }
    static int Sol(int num,int k){
        if (k == 1) {
            System.out.println(num);
            return num;
        }
        
        int result = Sol(num, k - 1) + num;
        System.out.println(result);
        return result;
    }
    static void Sol2(int num,int k){
        if(k==1){
            System.out.println(num);
            return;
        }
         Sol2(num, k-1);
        System.out.println(num*k);
    }
}
