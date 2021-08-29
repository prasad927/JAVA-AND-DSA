class Find CenterOfStarGraph{
    public int findCenter(int[][] edges) {
        //undirected
        int n = edges.length+1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //check each VTX;
        for(int i=1;i<=graph.size();i++){
            int size = graph.get(i).size();
            
            if(size==edges.length){
                return i;
            }
        }
        return -1;
    }
}