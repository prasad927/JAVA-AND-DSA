class waysToConstructBuildings{
     public int TotalWays(int N)
    {
       //0 space
       //1 building
       long[][] dp = new long[2][N+1];
       long ans=arrangeBuildings(N,0,dp);
       long ans1 = ans%1000000007;
       return (int) ((ans1*ans1)%1000000007);
    }
    
    private long arrangeBuildings(int n,int prev,long[][] dp){
        if(n==0){
            return 1;
        }
        
        if(dp[prev][n]!=0){
            return dp[prev][n];
        }
        
        if(prev==0){
            long sp = arrangeBuildings(n-1,0,dp);
            long bld = arrangeBuildings(n-1,1,dp);
            return dp[prev][n]=(sp%1000000007+bld%1000000007)%1000000007;
        }else{
            return dp[prev][n]=arrangeBuildings(n-1,0,dp)%1000000007;
        }
    }
}