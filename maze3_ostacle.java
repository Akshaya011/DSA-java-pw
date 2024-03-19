public class maze3_ostacle {
    public static void main(String[] args) {
        boolean board[][] = {{true,true,true,true},
                            {true,true,false,true},
                            {true,true,true,true}
                            };
        path(0,0,"" ,board);
    }
    static void path(int r,int c,String p, boolean[][] board){
        if(r >= board.length || c >= board[0].length) return;
        if(r==board.length-1 && c== board[0].length-1){
            System.out.println(p);
            return;
        }
        if(board[r][c]==false) return;

        // board[r][c]=false;
        if(r<board.length) path(r+1,c,p+"D",board);
        if(c<board[0].length) path(r,c+1,p+"R",board);
        
    }
}
