import java.util.ArrayList;

public class printpermutation {
    public static void main(String[] args) {
        print("","abc");
        int nums[]={1,2,3};
        List<List<Integer>> ans=new ArrayList<>();
        ans=permutation(nums);
        System.out.println(ans);
    }
   static void print(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            print(f+ch+s,up.substring(1));

        }
        
    }
    static List<List<Integer>> permutation(int nums[]){
        List<List<Integer>> ans=new ArrayList<>();
        return helper(nums, ans, 0);
    }
    static void helper(int nums[],List<List<Integer>> ans,int i){
        int n=nums.length;
        if(i==n-1){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<n;j++){
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }
    
    for(int j=i;j<n;j++){
        swap(j,i+1,nums);
        helper(nums, ans, j);
        swap(j,i+1,nums);
    }
}
    static void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[i+1];
        nums[i+1]=temp;
    }
}


