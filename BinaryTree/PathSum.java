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
class PathSum{
    public boolean hasPathSumHelper(TreeNode root,int targetSum,int currSum){
            if(root==null){
                return false;
            }
            if(root.left==null && root.right==null){
                currSum+=root.val;
                if(currSum==targetSum){
                    return true;
                }
                return false;
            }
        
            boolean lres = hasPathSumHelper(root.left,targetSum,currSum+root.val);
            
            if(lres==true){
                return true;
            }
        
            boolean rres = hasPathSumHelper(root.right,targetSum,currSum+root.val);
            if(rres==true){
                return true;
            }
        
            return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
            if(root==null){
                return false;
            }
        
            return hasPathSumHelper(root,targetSum,0);
    }
}