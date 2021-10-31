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
class TrimBST{
      
    public int max(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root.val;
    }
    
    public TreeNode deleteTarget(TreeNode root,int target){
        
        if(root==null){
            return null;
        }

        if(root.val>target){
            root.left = deleteTarget(root.left,target);
        }else if(root.val<target){
            root.right = deleteTarget(root.right,target);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                //both child exist;
                int max = max(root.left);
                root.val = max;
                root.left = deleteTarget(root,max);
            }
        }
        return root;
    }
    
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        if(root==null){
            return null;
        }
        
        if(root.val<low || root.val>high){
            //valid to delete
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                //both child exist;
                int max = max(root.left);
                root.val = max;
                root.left = deleteTarget(root,max);
            }
        }else{
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }
        
        return root;
    }
}