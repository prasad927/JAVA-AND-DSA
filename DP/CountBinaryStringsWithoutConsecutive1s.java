class CountBinaryStringsWithoutConsecutive1s{
     long countStrings(int n) {
       long[][] dp = new long[2][n+1];
       
       //last used 0 in argument just for start.
       return helper(n,0,dp)%1000000007; // given in question.
    //   System.out.println(res);
    //   return res%1000000007;
    }
    
    public long helper(int len,int lastUsed,long[][] dp){
        
        if(len==0){
            return 1;
        }
        
        if(dp[lastUsed][len]!=0){
            return dp[lastUsed][len];
        }
        
        long count = 0;
        if(lastUsed==0){
            //call both
            count+=helper(len-1,0,dp);
            count+=helper(len-1,1,dp);
        }else{
            count+=helper(len-1,0,dp);
        }
        
        return dp[lastUsed][len] = count%1000000007; //Store ans also in modulo form.
    }
}