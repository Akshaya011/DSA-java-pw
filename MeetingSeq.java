import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MeetingSeq {
    public static class Meet implements Comparable<Meet>{
        int starttime;
        int finishtime;
        int meetingnumber;

        Meet(int st,int ft,int mn){
            this.starttime=st;
            this.finishtime=ft;
            this.meetingnumber=mn;
        }

        public String toString(){
            String str="{"+this.starttime+", "+this.finishtime+"}";
            return str;
        }
        @Override
        public int compareTo(Meet a){
            return (this.finishtime-a.finishtime);
        }
    }
    public static void main(String[] args) {
        List<Integer> start=List.of(1,3,0,5,8,5);
        List<Integer> finish=List.of(2,4,6,7,8,9);
        List<Meet> meeting=new ArrayList<>();
        for(int i=0;i<start.size();i++){
            Meet a=new Meet(start.get(i), finish.get(i), i+1);
            meeting.add(a);
        }
        System.out.println(meeting);
        Collections.sort(meeting);
        System.out.println(meeting);

        List<Integer> result=new ArrayList<>();
        Meet ongoingmeet=meeting.get(0);
        result.add(ongoingmeet.meetingnumber);
        for(int i=1;i<meeting.size();i++){
            if(meeting.get(i).starttime>=ongoingmeet.finishtime){
                result.add(meeting.get(i).meetingnumber);
                ongoingmeet=meeting.get(i);
            }

        }
        System.out.println(result);
    }
}
