class NearestExitEntranceInMaze{
    
    class pair{
        int row;
        int col;
        
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
         
        int nr = maze.length;
        int nc = maze[0].length;
        boolean[][] visited = new boolean[nr][nc];
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};        
        
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(entrance[0],entrance[1]));
        visited[entrance[0]][entrance[1]]=true;
        int level=0;
        while(q.size()!=0){
            int currsize = q.size();
            
            while(currsize!=0){
                
                pair p = q.remove();
                
                if(p.row==0 || p.col==0 || p.row==maze.length-1 || p.col==maze[0].length-1){
                    if(level!=0){
                        return level;
                    }
                }
                
                
                for(int d=0;d<4;d++){
                    int rowDash = p.row+dir[d][0];
                    int colDash = p.col+dir[d][1];
                    
                    
                    if(rowDash<0 || colDash<0 || rowDash>=maze.length || colDash>=maze[0].length || maze[rowDash][colDash]=='+' || visited[rowDash][colDash]==true){
                        continue;
                    }
                    
                    q.add(new pair(rowDash,colDash));
                    visited[rowDash][colDash]=true;
                }
                currsize--;
            }
            level++;
        }
        return -1;
    }
}