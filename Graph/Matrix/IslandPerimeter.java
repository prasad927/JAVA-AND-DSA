class islandPerimeter{
    public int islandPerimeter(int[][] grid) {
        //1 -->land 0-->water
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    //land found
                    int[] prm = {0};
                    countPerimeter(grid,i,j,prm);
                    return prm[0];
                }
            }
        }
        return 0;
    }
    
    private void countPerimeter(int[][] grid,int row,int col,int[] prm){
        
        grid[row][col]=2;
    
        
        if(row-1>=0){
            if(grid[row-1][col]==1){
                countPerimeter(grid,row-1,col,prm);
            }else if(grid[row-1][col]==0){
                prm[0]++;
            }
        }else{
            prm[0]++;
        }
        
         
        if(col+1<grid[row].length){
            if(grid[row][col+1]==1){
                countPerimeter(grid,row,col+1,prm);
            }else if(grid[row][col+1]==0){
                prm[0]++;
            }
        }else{
            prm[0]++;
        }
        
        if(row+1<grid.length){
            if(grid[row+1][col]==1){
                countPerimeter(grid,row+1,col,prm);
            }else if(grid[row+1][col]==0){
                prm[0]++;
            }
        }else{
            prm[0]++;
        }
        
        if(col-1>=0){
            if(grid[row][col-1]==1){
                countPerimeter(grid,row,col-1,prm);
            }else if(grid[row][col-1]==0){
                prm[0]++;
            }
        }else{
            prm[0]++;
        }
    }
}