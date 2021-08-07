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
    
    public TreeNode helper(TreeNode root){
        
        if(root==null){
            return null;
        }
        
        if(root.left==null && root.right==null){
            return root;
        }
        
        TreeNode ltail = helper(root.left);
        TreeNode rtail = helper(root.right);
        
        if(ltail!=null && rtail!=null){
            ltail.right=root.right;
            root.right = root.left;
            root.left=null;
            return rtail;
        }else if(ltail==null){
            root.left=null;
            return rtail;
        }else{
            root.right = root.left;
            root.left=null;
            return ltail;
        }
    }
    
    public void flatten(TreeNode root) {
        
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            return;
        }
    
        TreeNode ltail = helper(root.left);
        TreeNode rtail = helper(root.right);
        
        
        if(ltail!=null && rtail!=null){
            ltail.right=root.right;
            root.right = root.left;
            root.left=null;
        }else if(ltail==null){
            root.left=null;
        }else{
            root.right = root.left;
            root.left=null;
        }
        
            
        /* 2nd approach 
          Only using flatten fun. just loop required to find last node in flatten subtree*/
            
        /*
            flatten(root.left);
            flatten(root.right);
    
            if(root.left!=null && root.right!=null){
        
                 TreeNode temp = root.left;
        
                 while(temp.right!=null){
                   temp=temp.right;
                 }
        
                 temp.right = root.right;
                 root.right = root.left;
                 root.left=null;
            }else if(root.left==null){
                 root.left=null;
            }else if(root.right==null){
                 root.right = root.left;
                 root.left=null;
            }*/
    }
}