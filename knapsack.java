import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class knapsack{
    private static class Item{
        int val;
        int wt;
        Item(int val,int wt){
            this.val=val;
            this.wt=wt;
        }
        public String toString(){
            return val+" "+wt;
        }
    }
    private static class ItemComparator implements Comparator<Item>{
        public int compare(Item a,Item b){
            if((a.val/a.wt) < (b.val/b.wt)) return 1;
            else if((a.val/a.wt) > (b.val/b.wt)) return -1;
            else return 0;
        }
    }
    public static void main(String[] args) {
        List<Integer> value=List.of(60,100,150,120);
        List<Integer> weight=List.of(10,20,50,15);
        List<Item> itemlList=new ArrayList<>();
        for(int i=0;i<value.size();i++){
            Item a=new Item(value.get(i),weight.get(i));
            // a.val=value.get(i);
            // a.wt=weight.get(i);
            itemlList.add(a);
        }
        int W=30;
        itemlList.sort(new ItemComparator());
        System.out.println(itemlList);
        int profit=0;
        
            for(int i=0;i<itemlList.size()&& W>0;i++){
                Item a=itemlList.get(i);
                if(a.wt<=W){
                    profit+=a.val;
                    W-=a.wt;
                }else{
                    profit+=(a.val/a.wt)*W;
                    W=0;
                }
            }
        
        System.out.println("profit = "+profit);
    }
}