public class BasicRec{
    static void printDecreasing(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
    static int fib(int n){
        if( n <= 1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    static int digitSum(int n){
        if(n % 10 == n){
            return n;
        }
        return n%10 + digitSum(n/10);
    }
    static int sum(int n,int ans) {
        if(n==0){
            return ans;
        } else {
            ans+= n%10;
        }
        return sum(n/10, ans);
    }
    static int power(int p,int q){
        if(q==0){
            return 1;
        }
        return power(p, q-1)*p; 
    }
    static int power2(int p,int q){
        if(q==0){
            return 1;
        }
        if(q%2 !=0){
            return power(p, q/2)*power(p, q/2)*p;
        }
        return power(p, q/2)*power(p, q/2); 
    }
    public static void main(String[] args) {
        // printDecreasing(5);
        // System.out.println(fib(5));
        // System.out.println(digitSum(123456));
        // System.out.println(sum(12345, 0));
        System.out.println(power2(2, 6));
    }
}