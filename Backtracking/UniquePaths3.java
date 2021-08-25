class UniquePaths3{
    public int uniquePathsIII(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        boolean[][] visited = new boolean[nr][nc];
        
        int count=0;
        boolean isSTPF = false;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==1){
                    isSTPF=true;
                    count+=travelGrid(grid,row,col,visited,1);
                    break;
                }
            }
            if(isSTPF){
                break;
            }
        }
        return count;
    }
    static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    
    private int travelGrid(int[][] grid,int row,int col,boolean[][] visited,int boxCount){
        
        
        if(grid[row][col]==2){
            if(boxCount==grid.length*grid[0].length){
                return 1;
            }else{
                return 0;
            }
        }
        
        visited[row][col]=true;
        int count=0;
        for(int d=0;d<4;d++){
            int rowD = row+dir[d][0];
            int colD = col+dir[d][1];
            
            if(rowD<0 || colD<0 || rowD>=grid.length || colD>=grid[0].length){
                continue;
            }
            
            if(grid[rowD][colD]==1){
                continue;
            }
            if(grid[rowD][colD]==-1){
                boxCount++;
                continue;
            }
            if(visited[rowD][colD]==true){
                continue;
            }
            
            count+=travelGrid(grid,rowD,colD,visited,boxCount+1);
        }
        visited[row][col]=false;
        return count;
    }
}