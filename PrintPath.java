public class PrintPath {

    public static void main(String[] args) {
        int r=3,c=3;
        boolean isvisited[][]= new boolean[r][c];
        path(0,0,r-1,c-1,"",isvisited);
    }
    static void path(int sr,int sc,int er,int ec,String p,boolean isvisited[][]){
        // if(sr>er || sc > ec){
        //     return 0;
        // }
        if(sr<0 || sc<0) return;
        if(sr>er || sc>ec) return;
        if(isvisited[sr][sc]) return;
        if(sr==er && sc == ec){
            System.out.println(p);
            return;
        }
        isvisited[sr][sc]=true;
        if(sr<er) path(sr+1,sc,er,ec,p+'D', isvisited);
        if(sc<ec) path(sr,sc+1,er,ec,p+'R', isvisited);
        if(sc>0) path(sr,sc-1,er,ec,p+'L', isvisited);
        if(sc>0) path(sr-1,sc,er,ec,p+'U', isvisited);
        isvisited[sr][sc] =false;
    }
}
