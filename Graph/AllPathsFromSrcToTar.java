class AllPathsFromSrcToTar{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
           List<List<Integer>> ans = new ArrayList<>();
        
           ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
           for(int i=0;i<graph.length;i++){
                graph1.add(new ArrayList<>());
           }
           
           for(int i=0;i<graph.length;i++){
               int[] nbrs = graph[i];
               ArrayList<Integer> vtx = graph1.get(i);
               
               for(int nbr:nbrs){
                   vtx.add(nbr);
               }
           }
          //0 to n-1 && a-cyclic
           allPathsHelper(graph1,0,graph.length-1,new ArrayList<>(),ans);
           return ans;
    }
    public static void allPathsHelper(ArrayList<ArrayList<Integer>> graph,int src,int tar,List<Integer> currpath,List<List<Integer>> ans){
         
        if(src==tar){
            //reached
            List<Integer> copy = new ArrayList<>();
            for(int i:currpath){
                copy.add(i);
            }
            copy.add(tar);
            ans.add(copy);
            return;
        }
        currpath.add(src);
        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr:nbrs){
            allPathsHelper(graph,nbr,tar,currpath,ans);
        }
        currpath.remove(currpath.size()-1);//backtrack
    }
}