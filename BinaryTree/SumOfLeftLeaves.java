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
class SumOfLeftLeaves{
    public int sumOfLeftLeavesHelp(TreeNode root,TreeNode par){
        
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            //leaf
            if(par!=null && par.left==root){
                return root.val;
            }
            return 0;
        }
        
        int leftSum = sumOfLeftLeavesHelp(root.left,root);
        int rightSum = sumOfLeftLeavesHelp(root.right,root);
        
        return leftSum+rightSum;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int ans =  sumOfLeftLeavesHelp(root,null);
        return ans;
    }
}