//leetcode version

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
    
    private int sum;
    
    public TreeNode convertBST_(TreeNode root){
        if(root==null){
            return null;
        }
    
        TreeNode nr = new TreeNode(0);
        nr.right = convertBST_(root.right);
        int val = sum+root.val;
        nr.val = val;
        sum = val;
        
        nr.left = convertBST_(root.left);
        
        return nr;
    }
    
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        if(root==null){
            return null;
        }
        
        return convertBST_(root);
    }
}