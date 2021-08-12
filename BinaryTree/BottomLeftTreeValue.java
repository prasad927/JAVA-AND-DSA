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
class BottomLeftTreeValue{
    public int findBottomLeftValue(TreeNode root){
        
       /*  Using level order
        Queue<TreeNode> mainq = new ArrayDeque<>();
        TreeNode ans = null;
        mainq.add(root);
        
        while(mainq.size()>0){
            int currsize = mainq.size();
            
            for(int i=0;i<currsize;i++){
                TreeNode rmvd = mainq.remove();
                
                if(i==0){
                    ans = rmvd;
                }
                
                if(rmvd.left!=null){
                    mainq.add(rmvd.left);
                }
                
                if(rmvd.right!=null){
                    mainq.add(rmvd.right);
                }
            }
        }
        return ans.val;*/
        
        //Using DFS
        int[] depth={-1};
        int[] ans ={0};
        helper(root,depth,ans,0);
        return ans[0];
    }
    
    public void helper(TreeNode root,int[] depth,int[] ans,int cdepth){
        
        if(root==null){
            return;
        }
        
        if(depth[0]<cdepth){
            ans[0]=root.val;
            depth[0]=cdepth;
        }
        
        helper(root.left,depth,ans,cdepth+1);
        helper(root.right,depth,ans,cdepth+1);
    }
}