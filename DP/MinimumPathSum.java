class MinimumPathSum{
    public int minPathSum(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        
        int[][] dp = new int[nr][nc];
        
        for(int row=nr-1;row>=0;row--){
            for(int col=nc-1;col>=0;col--){
                if(row==nr-1 && col==nc-1){
                    dp[row][col]=grid[row][col];
                }else if(row==nr-1){
                    dp[row][col]=grid[row][col]+dp[row][col+1];
                }else if(col==nc-1){
                    dp[row][col]=grid[row][col]+dp[row+1][col];
                }else{
                    dp[row][col]=grid[row][col]+Math.min(dp[row][col+1],dp[row+1][col]);
                }
            }
        }
        return dp[0][0];
    }
}