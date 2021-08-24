class WordSearch{
    public boolean exist(char[][] board, String word) {
        int nr = board.length;
        int nc = board[0].length;
        boolean[][] visited = new boolean[nr][nc];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                     boolean res = isExist(board,i,j,visited,word,0);
                     if(res){
                         return true;
                     }
                }
            }
        }
        return false;
    }
    
    private boolean isExist(char[][] board,int row,int col,boolean[][] visited,String word,int idx){
        
        if(word.length()-1==idx){
            return true;
        }
        visited[row][col]=true;
        char nxt = word.charAt(idx+1);
        
        if(row-1>=0 && board[row-1][col]==nxt && !visited[row-1][col]){
            if(isExist(board,row-1,col,visited,word,idx+1)){
                visited[row][col]=false;
                return true;
            }
        }
        
        if(col+1<board[row].length && board[row][col+1]==nxt && !visited[row][col+1]){
            if(isExist(board,row,col+1,visited,word,idx+1)){
                visited[row][col]=false;
                return true;
            }
        }
        
        if(row+1<board.length && board[row+1][col]==nxt && !visited[row+1][col]){
            if(isExist(board,row+1,col,visited,word,idx+1)){
                visited[row][col]=false;
                return true;
            }
        }
        
        if(col-1>=0 && board[row][col-1]==nxt && !visited[row][col-1]){
             if(isExist(board,row,col-1,visited,word,idx+1)){
                visited[row][col]=false;
                return true;
            }
        }
        visited[row][col]=false;
        return false;
    }
}