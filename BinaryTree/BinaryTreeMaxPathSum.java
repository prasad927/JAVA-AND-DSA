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
class Solution {
    
    int maxSum;
    public int maxPathSum_(TreeNode root){
        
        if(root==null){
            return -1001;
        }
        
        if(root.left==null && root.right==null){
            if(maxSum<root.val){
                maxSum = root.val;
            }
            return root.val;
        }

        int lans = maxPathSum_(root.left);
        int rans = maxPathSum_(root.right);
       
       if(root.left!=null && root.right!=null){ 
           int ans = lans+rans+root.val;

           ans = Math.max(lans+root.val,ans);
           ans = Math.max(rans+root.val,ans);
           ans = Math.max(root.val,ans);
           if(maxSum<ans){
               maxSum=ans;
           }
       }else{
           
           int ans = Math.max(lans,rans)+root.val;
           ans = Math.max(root.val,ans);
           if(maxSum<ans){
               maxSum=ans;
           } 
       }
       return Math.max(Math.max(lans,rans)+root.val,root.val);
    }
    
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSum_(root);
        return maxSum;
    }
}