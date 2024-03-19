import java.util.ArrayList;
import java.util.List;

public class Meeting{
    public static class Meet{
        int starttime;
        int finishtime;
        public String toString(){
            return starttime+" "+finishtime;
        }
    }
    public static void main(String[] args) {
        List<Integer> start=List.of(1,3,0,5,8,5);
        List<Integer> finish=List.of(2,4,6,7,9,9);
        List<Meet> meetingList=new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            Meet a=new Meet();
            a.starttime=start.get(i);
            a.finishtime=finish.get(i);
        }
    }
}