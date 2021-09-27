class UniquePaths2{
    public int uniquePathsWithObstaclesHelp(int[][] obstacleGrid,int sr,int sc,int dr,int dc,int dp[][]){
        
        if(obstacleGrid[sr][sc]==1){
            return 0;
        }
        
        
        if(sr==dr && sc==dc){
            return 1;
        }
        
        
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        
        int ans=0;
        if(sr==dr){
            ans+=uniquePathsWithObstaclesHelp(obstacleGrid,sr,sc+1,dr,dc,dp);
        }else if(sc==dc){
            ans+=uniquePathsWithObstaclesHelp(obstacleGrid,sr+1,sc,dr,dc,dp);
        }else{
            ans+=uniquePathsWithObstaclesHelp(obstacleGrid,sr,sc+1,dr,dc,dp);
            ans+=uniquePathsWithObstaclesHelp(obstacleGrid,sr+1,sc,dr,dc,dp);
        }
        
        return dp[sr][sc]=ans;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nr = obstacleGrid.length;
        int nc = obstacleGrid[0].length;
        int[][] dp = new int[nr][nc];
        
        //int ans = uniquePathsWithObstaclesHelp(obstacleGrid,0,0,nr-1,nc-1,dp);
        
        //tabulated
        for(int row=obstacleGrid.length-1;row>=0;row--){
            for(int col=obstacleGrid[row].length-1;col>=0;col--){
              
              if(obstacleGrid[row][col]!=1){
                
                  if(row==nr-1 && col==nc-1){
                     dp[row][col]=1;
                  }else if(row==nr-1){
                     dp[row][col]=dp[row][col+1];
                  }else if(col==nc-1){
                     dp[row][col]=dp[row+1][col];
                  }else{
                     dp[row][col]=dp[row+1][col]+dp[row][col+1];
                  }
               }else{
                  dp[row][col]=0;
               }
            }
        }
        
        return dp[0][0];
    }
}