class WordSearch2{
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<words.length;i++){
            String toSearch = words[i];
            
            boolean isFound=false;
            for(int row=0;row<board.length;row++){
                for(int col=0;col<board[row].length;col++){
                    if(board[row][col]==toSearch.charAt(0)){
                        boolean res = isExists(board,row,col,toSearch,0);
                        if(res){
                            isFound=true;
                            list.add(toSearch);
                            break;
                        }
                    }
                }  
                if(isFound){
                    break;
                }
            }
        }
        return list;
    }
    
    private boolean isExists(char[][] board,int row,int col,String toSearch,int idx){
            
            if(toSearch.length()-1==idx){
                return true;
            }
            char curr=board[row][col];
            board[row][col]='@';    
        
            char nxt = toSearch.charAt(idx+1);
            if(row-1>=0 && board[row-1][col]==nxt){
                 boolean res = isExists(board,row-1,col,toSearch,idx+1);
                 
                 if(res){
                     board[row][col]=curr;
                     return res;
                 }
            }
        
            if(col+1<board[row].length && board[row][col+1]==nxt){
                 boolean res = isExists(board,row,col+1,toSearch,idx+1);
                
                 if(res){
                     board[row][col]=curr;
                     return res;
                 }
            }
        
            if(row+1<board.length && board[row+1][col]==nxt){
                 boolean res = isExists(board,row+1,col,toSearch,idx+1);
                
                 if(res){
                     board[row][col]=curr;
                     return res;
                 }
            }
        
            if(col-1>=0 && board[row][col-1]==nxt){
                 boolean res = isExists(board,row,col-1,toSearch,idx+1);
                
                 if(res){
                     board[row][col]=curr;
                     return res;
                 }
            }
            board[row][col]=curr;
            return false;
    }
}