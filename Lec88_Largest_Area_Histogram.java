import java.util.Stack;

public class Lec88_Largest_Area_Histogram {
    public static void main(String[] args) {
        int arr[]={2,1,3,4,2,5,1,2,0};
        NSE(arr);
        int arr2[]={0,2,1,3,4,2,5,1,2};
        NSErev(arr2);
        
    }
    static void NSE(int[] arr){
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int a[]=new int[arr.length];int k=0;
        for(int i=1;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                a[st.pop()]=i;                
            }
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    static void NSErev(int[] arr){
        Stack<Integer> st=new Stack<>();
        st.push(arr.length-1);
        int a[]=new int[arr.length];int k=0;
        for(int i=arr.length-2;i>=0;i--){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                a[st.pop()]=i;                
            }
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
