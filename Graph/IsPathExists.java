class IsPathExists{
    
    private class Edge{
        int src;
        int dest;
        
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        //0-->n-1
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Edge>());
        }
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            
            graph.get(src).add(new Edge(src,dest));
            graph.get(dest).add(new Edge(dest,src));
        }
        
        
        boolean res = dfs(graph,start,end,new boolean[n]);
        
        return res;
        
    }
    
    public boolean dfs(ArrayList<ArrayList<Edge>> graph,int start,int end,boolean[] visited){
        
        if(start==end){
            return true;
        }
        
        visited[start]=true;
        for(Edge e:graph.get(start)){
            if(visited[e.dest]==false){
                boolean res = dfs(graph,e.dest,end,visited);
                if(res){
                    return res;
                }
            }
        }
        return false;
    }
}