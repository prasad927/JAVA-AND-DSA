/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSum2{
    
    public void pathSumHelp(TreeNode root,ArrayList<Integer> ans,List<List<Integer>> mainans,int currsum,int targetsum){
        
        if(root==null){
            return;
        }
          
        if(root.left==null && root.right==null){
            currsum+=root.val;
            if(currsum==targetsum){
                ArrayList<Integer> nans = new ArrayList<>();
                
                for(Integer num:ans){
                    nans.add(num);
                }
                nans.add(root.val);
                mainans.add(nans);
            }
            return;
        }
        ans.add(root.val);
        pathSumHelp(root.left,ans,mainans,currsum+root.val,targetsum);
        pathSumHelp(root.right,ans,mainans,currsum+root.val,targetsum);
        ans.remove(ans.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> mainans = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        pathSumHelp(root,ans,mainans,0,targetSum);
        return mainans;
        
        
        
        /* SLOW CODE 
        if(root.left==null && root.right==null){
            int remSum = targetSum-root.val;
            if(remSum==0){
                 List<List<Integer>> mainans = new ArrayList<>();
                 List<Integer> ans = new ArrayList<>();
                 ans.add(root.val);
                 mainans.add(ans);
                 return mainans;
            }else{
                 return new ArrayList<>();
            }
        }
        List<List<Integer>> mainans = new ArrayList<>();
        
        List<List<Integer>> leftans = pathSum(root.left,targetSum-root.val);
        List<List<Integer>> rightans = pathSum(root.right,targetSum-root.val);
        
        
        for(List<Integer> list:leftans){
            list.add(0,root.val);
            mainans.add(list);
        }
        
        for(List<Integer> list:rightans){
            list.add(0,root.val);
            mainans.add(list);
        }
        
        return mainans;*/
    }
}