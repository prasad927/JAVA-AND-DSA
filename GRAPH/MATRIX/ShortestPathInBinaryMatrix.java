class  ShortestPathInBinaryMatrix{
    
    public class pair{
        int row;
        int col;
        
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0]==1){
            return -1;
        }
        int n = grid.length;
        
        if(n==1){
            return grid[0][0]==1 ? -1:1;
        }
        //all 8 directions
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
        
        LinkedList<pair> q = new LinkedList<>();
        q.addLast(new pair(0,0));
        grid[0][0]=1;
        int level=1;
        while(q.size()!=0){
            int currsize=q.size();
            while(currsize!=0){
                pair p = q.removeFirst();
                
                for(int d=0;d<dir.length;d++){
                    int rowD = dir[d][0]+p.row;
                    int colD = dir[d][1]+p.col;
                    
                    if(rowD<0 || colD<0 || rowD>=grid.length || colD>=grid[0].length || grid[rowD][colD]==1){
                        continue;
                    }
                    
                    if(rowD==n-1 && colD==n-1){
                        return level+1;
                    }
                    grid[rowD][colD]=1;
                    q.addLast(new pair(rowD,colD));
                }
                currsize--;
            }
            level++;
        }
        return -1;
    }
}