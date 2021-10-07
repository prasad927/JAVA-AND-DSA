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
class RightSideViewOfBT{
    public List<Integer> rightSideView(TreeNode root) {
        
        /*if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> mainq = new ArrayDeque<>();
        mainq.add(root);
        
        while(mainq.size()>0){
            int currsize = mainq.size();
            
            for(int i=0;i<currsize;i++){
                TreeNode rmvd = mainq.remove();
                
                if(i==currsize-1){
                    ans.add(rmvd.val);
                }
                
                if(rmvd.left!=null){
                    mainq.add(rmvd.left);
                }
                
                if(rmvd.right!=null){
                    mainq.add(rmvd.right);
                }
            }
        }
        
        return ans;*/
        //Recursive approach
        List<Integer> list = new ArrayList<>();
        helper(root,0,list);
        return list;
    }
    
    private void helper(TreeNode root,int level,List<Integer> list){
        
        if(root==null){
            return;
        }
        
        if(level==list.size()){
            list.add(root.val);
        }
        
        helper(root.right,level+1,list); //first go to right side.
        helper(root.left,level+1,list);
    }
}