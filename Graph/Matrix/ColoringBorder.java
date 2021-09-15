class ColoringBorder{
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        //color-->color boundry with this color
        int nr = grid.length;
        int nc = grid[0].length;
        boolean[][] visited = new boolean[nr][nc];
        dfs(grid,row,col,color,grid[row][col],visited);
        
        return grid;
    }
    
    public void dfs(int[][] grid,int row,int col,int color,int pcolor,boolean[][] visited){
        
            
        visited[row][col]=true;
        int callCount=0;
        
        if(row-1>=0){
              if(visited[row-1][col]==true){
                  callCount++;
              }else if(grid[row-1][col]==pcolor){
                  callCount++;
                  dfs(grid,row-1,col,color,pcolor,visited);
              }
        }
        
        if(col+1<grid[row].length){
              if(visited[row][col+1]==true){
                  callCount++;
              }else if(grid[row][col+1]==pcolor){
                  callCount++;
                  dfs(grid,row,col+1,color,pcolor,visited);
              }
        }
        
        if(row+1<grid.length){
            if(visited[row+1][col]==true){
                callCount++;
            }else if(grid[row+1][col]==pcolor){
                callCount++;
                dfs(grid,row+1,col,color,pcolor,visited);
            }
        }
        
        if(col-1>=0){
            
            if(visited[row][col-1]==true){
                callCount++;
            }else if(grid[row][col-1]==pcolor){
                callCount++;
                dfs(grid,row,col-1,color,pcolor,visited);
            }
        }
        
        if(callCount<4){
            grid[row][col]=color;
        }
    }
}