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

/*
Input: root = [1,2,3]-->level-order
Output: 25
*/
class sumRootToLeafNums{
    
    public void sumNumbers(TreeNode root,int currSum,int[] ans){
        
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            currSum = currSum*10+root.val;
            ans[0]+=currSum;
        }   
        
        
        sumNumbers(root.left,currSum*10+root.val,ans);
        sumNumbers(root.right,currSum*10+root.val,ans);
    }
    public int sumNumbers(TreeNode root) {
        int[] ans={0};
        sumNumbers(root,0,ans);
        return ans[0];
    }
}