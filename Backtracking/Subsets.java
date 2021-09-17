class Subsets{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> helper = new ArrayList<>();
        subsets_(nums,0,ans,helper);
        return ans;
    }
    
    public void subsets_(int[] nums,int curr,List<List<Integer>> ans,List<Integer> helper){
        
        if(curr==nums.length){
           List<Integer> list = new ArrayList<>();
           for(int i:helper){
                list.add(i);
           }
           ans.add(list);
           return;
        }
        
        int num = nums[curr];
        subsets_(nums,curr+1,ans,helper);
        
        helper.add(num);
        subsets_(nums,curr+1,ans,helper);
        helper.remove(helper.size()-1);//back-track
    }
}