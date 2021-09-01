class maxAreaOfIsland{
    public int maxAreaOfIsland(int[][] grid) {
         
        
        int[] acount = {0};
        int maxArea = 0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                 if(grid[row][col]==1){
                     // land found
                     countArea(grid,row,col,acount);
                     
                     if(maxArea<acount[0]){
                         maxArea=acount[0];
                     }
                     acount[0]=0;
                 }
            }
        }
        return maxArea;
    }
    
    private void countArea(int[][] grid,int row,int col,int[] acount){
        
        acount[0]+=1;
        grid[row][col]=0;//visit
        
        if(row-1>=0 && grid[row-1][col]==1){
            countArea(grid,row-1,col,acount);
        }
        
        if(col+1<grid[row].length && grid[row][col+1]==1){
            countArea(grid,row,col+1,acount);
        }
        
        if(row+1<grid.length && grid[row+1][col]==1){
            countArea(grid,row+1,col,acount);
        }
        
        if(col-1>=0 && grid[row][col-1]==1){
            countArea(grid,row,col-1,acount);
        }
    }
}