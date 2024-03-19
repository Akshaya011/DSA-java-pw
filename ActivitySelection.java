import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
    public static class Activity implements Comparable<Activity>{
        int startday;
        int endday;
        public Activity(int a,int b){
            this.startday=a;
            this.endday=b;
        }
        public String toString(){
            return "{"+this.startday+", "+this.endday+"}";
        }
        public int compareTo(Activity a){
            return this.endday-a.endday;
        }
    }
    public static void main(String[] args) {
        List<Integer> start=List.of(1,3,2,5);
        List<Integer> end=List.of(2,4,3,6);
        List<Activity> ActivityList=new ArrayList<>();
        
        for (int i = 0; i < start.size(); i++) {
            Activity a=new Activity(start.get(i),end.get(i));
            ActivityList.add(a);
        }
        Collections.sort(ActivityList);
        System.out.println(ActivityList);
        Activity curr=ActivityList.get(0);int ans=0;
        for(int i=1;i<ActivityList.size();i++){
            if(ActivityList.get(i).startday>=curr.endday){
                ans++;
                curr=ActivityList.get(i);
            }
        }
        System.out.println(ans);
    }
}
