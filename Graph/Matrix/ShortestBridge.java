class ShortestBridge{
    
    class pair{
        int row;
        int col;
        
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        
        boolean[][] visited = new boolean[nr][nc];
        Queue<pair> q = new ArrayDeque<>();
        
        boolean isLandF=false;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==1){
                    //1st island found
                    isLandF = true;
                    visitIsland(grid,row,col,visited,q);
                    break;
                }
            }
            if(isLandF){
                break;
            }
        }
        int level=0;
        while(q.size()!=0){
            int currsize=q.size();
            
            while(currsize>0){
                
                pair p = q.remove();
                
                if(grid[p.row][p.col]==1){
                    return level-1;
                }
                
                if(p.row-1>=0 && grid[p.row-1][p.col]!=2 && visited[p.row-1][p.col]==false){
                       visited[p.row-1][p.col]=true;
                       q.add(new pair(p.row-1,p.col));
                }
        
                if(p.col+1<grid[p.row].length && grid[p.row][p.col+1]!=2 && visited[p.row][p.col+1]==false){
                       visited[p.row][p.col+1]=true;
                       q.add(new pair(p.row,p.col+1));
                }
        
                if(p.row+1<grid.length && grid[p.row+1][p.col]!=2 && visited[p.row+1][p.col]==false){
                       visited[p.row+1][p.col]=true;  
                       q.add(new pair(p.row+1,p.col));
                }   
        
                if(p.col-1>=0 && grid[p.row][p.col-1]!=2 && visited[p.row][p.col-1]==false){
                       visited[p.row][p.col-1]=true;
                       q.add(new pair(p.row,p.col-1));
                }      
                currsize--;
            }
            level++;
        }
        return level;
        
    }
    
    private void visitIsland(int[][] grid,int row,int col,boolean[][] visited,Queue<pair> q){
        
        visited[row][col]=true;
        grid[row][col]=2;
        q.add(new pair(row,col));
        
        
        if(row-1>=0 && grid[row-1][col]==1 && visited[row-1][col]==false){
            visitIsland(grid,row-1,col,visited,q);
        }
        
        if(col+1<grid[row].length && grid[row][col+1]==1 && visited[row][col+1]==false){
            visitIsland(grid,row,col+1,visited,q);
        }
        
        if(row+1<grid.length && grid[row+1][col]==1 && visited[row+1][col]==false){
            visitIsland(grid,row+1,col,visited,q);
        }   
        
        if(col-1>=0 && grid[row][col-1]==1 && visited[row][col-1]==false){
            visitIsland(grid,row,col-1,visited,q);
        }
    }  
}