
// Number of Operations to Make Network Connected

class MakeNetworkConn{
    private int[] parent;
    private int[] rank;
    
    public int makeConnected(int n, int[][] connections) {
       //Using DSU
       parent = new int[n];
       rank = new int[n];
        
       for(int i=0;i<parent.length;i++){
           parent[i]=i;
           rank[i]=1;
       }
       int useLessConnection=0;
       int edgeForm=0;
       for(int i=0;i<connections.length;i++){
           int u = connections[i][0];
           int v = connections[i][1];
           
           int par_u=find(u);
           int par_v=find(v);
           
           if(par_u!=par_v){
              edgeForm++;
              int rank_par_u = rank[par_u];
              int rank_par_v = rank[par_v];
              
              if(rank_par_u>rank_par_v){
                  parent[par_v]=par_u;
              }else if(rank_par_u<rank_par_v){
                  parent[par_u]=par_v;
              }else{
                  parent[par_v]=par_u;
                  rank[par_u]++;
              }
           }else{
              useLessConnection++;
           }    
       }
       
       int compConn = edgeForm+1;
       int remComp = n-compConn;
       
       if(useLessConnection<remComp){
           return -1;
       }else{
           return remComp;
       }
       
    }
    
    private int find(int vtx){
        if(parent[vtx]==vtx){
            return vtx;
        }
        return parent[vtx]=find(parent[vtx]);
    }
}