class MaxSumNonAdjacentElements{
    public int FindMaxSum(int arr[], int n)
    {
        int[][] dp = new int[2][n+1];
        //0 exclude
        //1 include
        int ans = findMaxSum(arr,0,0,dp);
        return ans;
    }
    
    public int findMaxSum(int[] arr,int idx,int status,int[][] dp){
        if(idx==arr.length){
            return 0;
        }
        
        if(dp[status][idx]!=0){
            return dp[status][idx];
        }
        
        int ans=0;
        if(status==0){
            int inc = arr[idx] + findMaxSum(arr,idx+1,1,dp);
            int exc = findMaxSum(arr,idx+1,0,dp);
            ans = Math.max(inc,exc);
        }else{
            int exc = findMaxSum(arr,idx+1,0,dp);
            ans = exc;
        }
        return dp[status][idx]=ans;
    }
}