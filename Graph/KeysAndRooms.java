class KeysAndRooms{
    public void helper(List<List<Integer>> rooms,int currRoom,boolean[] visited,int[] visitedCount){
        
        
        visited[currRoom]=true;
        visitedCount[0]++;
        List<Integer> keys = rooms.get(currRoom);
        
        for(int key:keys){
            if(visited[key]==false){
                helper(rooms,key,visited,visitedCount);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int[] visitedCount={0};
        helper(rooms,0,visited,visitedCount);
    
        return visitedCount[0]==rooms.size() ? true:false;
    }
}