// 1.The town judge trusts nobody.
// 2.Everybody (except for the town judge) trusts the town judge.
// 3.There is exactly one person that satisfies properties 1 and 2.

class FindTownJudge{
    public int findJudge(int n, int[][] trust) {
        //ai--trust----->bi 1-->2
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        
        for(int i=0;i<trust.length;i++){
            int u = trust[i][0];
            int v = trust[i][1];
            outDegree[u]++;
            inDegree[v]++;
        }
        for(int i=1;i<=n;i++){
            if(outDegree[i]==0 && inDegree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}