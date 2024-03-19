import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumCost {
    public static void main(String[] args) {
        // aproach biggest cost first
        List<Integer> x=new ArrayList<>();
        x.add(2);x.add(1);x.add(3);x.add(1);x.add(4);
        List<Integer> y=new ArrayList<>();
        y.add(4);y.add(1);y.add(2);
        x.sort(Comparator.reverseOrder());
        y.sort(Comparator.reverseOrder());
        
        System.out.println(x);
        int M=6,N=4;

        int noOfVerticalPieces=1;
        int noOfHorizontalPieces=1;
        int i=0,j=0;

        int totalcost=0;
        while(i<M-1 && j<N-1){
            if(x.get(i)>y.get(j)){
                totalcost+=x.get(i)*noOfHorizontalPieces;
                noOfVerticalPieces++;
                i++;
            }else{
                totalcost+=y.get(j)*noOfVerticalPieces;
                noOfHorizontalPieces++;
                j++;
            }
        }
        while(i<M-1){
            totalcost+=x.get(i)*noOfHorizontalPieces;
            noOfVerticalPieces++;
            i++;
        }
        while(j<N-1){
            totalcost+=y.get(j)*noOfVerticalPieces;
            noOfHorizontalPieces++;
            j++;
        }
        System.out.println("total cost for cutting : "+totalcost);
    }
}
