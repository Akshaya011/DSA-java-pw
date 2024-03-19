public class LinearSearch_rec {
    public static void main(String[] args) {
        int arr[] = {14,12,54,14,3,8,6,14};
        // Search(arr, 8, 14);
        // System.out.println( Search2(arr, 8, 14, 0));
        // System.out.println( Searchindex(arr, 8, 14, 0));
        Search_Allindex(arr, 8, 14, 0);
    }
    static void Search(int arr[],int n,int target){
        if(n<0){
            System.out.println("not found");
            return;
        }
        if(arr[n-1]==target){
            System.out.println("yes found");
        }Search(arr, n-1, target);
    }
    static boolean Search2(int arr[],int n, int target,int idx){
        if(idx >= n){
            return false;
        }
        if(arr[idx]==target){
            return true;
        }
        return Search2(arr, n, target, idx+1);
    }
    static int Searchindex(int arr[],int n, int target,int idx){
        if(idx >= n){
            return -1;
        }
        if(arr[idx]==target){
            return idx;
        }
        return Searchindex(arr, n, target, idx+1);
    }
    static void Search_Allindex(int arr[],int n, int target,int idx){
        if(idx >= n){
            return ;
        }
        if(arr[idx]==target){
            System.out.println(idx);
        }
         Search_Allindex(arr, n, target, idx+1);
    }
}
