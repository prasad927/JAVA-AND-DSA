class Permutations{
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }
    
    public void helper(int[] nums,int placed,List<Integer> store,boolean[] used){
        
        if(placed==nums.length){
            List<Integer> temp = new ArrayList<>();
            
            for(int num:store){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        
        for(int j=0;j<nums.length;j++){
                if(used[j]==false){
                    //place
                    used[j]=true;
                    store.add(nums[j]);
                    helper(nums,placed+1,store,used);
                    used[j]=false;
                    store.remove(store.size()-1);
                }
        }
    }
}