public class MazePath {
    public static void main(String[] args) {
        System.out.println(path(1,1,3,3));
    }
    static int path(int sr,int sc,int er,int ec){
        // if(sr>er || sc > ec){
        //     return 0;
        // }
        if(sr==er || sc == ec){
            return 1;
        }
        
        int downWays = path(sr+1,sc,er,ec);
        int rightWays = path(sr,sc+1,er,ec);
        int totalWays = downWays + rightWays;
        return totalWays;
    }
}
