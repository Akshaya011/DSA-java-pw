import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class fractionalKnapsack{
    public static class good implements Comparable<good>{
        int price;
        int wt;

        good(int val,int wet){
            price=val;
            wt=wet;
        }
        public String toString(){
            String str="{"+this.price+","+this.wt+"}";
            return str;
        }

        public int compareTo(good a){
            return -(this.price/this.wt-a.price/a.wt);
        }

    }
    
    public static void main(String[] args) {
        
        List<Integer> price=List.of(60,100,120);
        List<Integer> wt=List.of(10,20,30);
        List<good> list=new ArrayList<>();
        for(int i=0;i<price.size();i++){
            good a=new good(price.get(i),wt.get(i));
            list.add(a);
        }
        int W=50;int ans=0;
        Collections.sort(list);
        // System.out.println(list);
        for(int i=0;i<list.size();i++){
            good a=list.get(i);
            if(a.wt<W){
                ans+=a.price;
                W-=a.wt;
            }else{
                ans+=W*(a.price/a.wt);
                W=0;
            }
        }

        System.out.println(ans);
    }
}