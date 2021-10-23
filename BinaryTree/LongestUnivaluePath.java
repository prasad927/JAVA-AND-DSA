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
class LongestUnivaluePath{
    int maxPath;
    public int longestUVP(TreeNode root){
        if(root==null){
            return -1;
        }
        
        if(root.left==null && root.right==null){
            return 0;
        }
        
        int lans = longestUVP(root.left);
        int rans = longestUVP(root.right);
        
        if(root.left!=null && root.right!=null){
            int ans=0;
            if(root.val==root.left.val && root.val==root.right.val){
                ans = lans+rans+2;
                maxPath = Math.max(maxPath,ans);
                return Math.max(lans,rans)+1;
            }else if(root.val==root.left.val){
                ans = lans+1;
                maxPath = Math.max(maxPath,ans);
                return lans+1;
            }else if(root.val==root.right.val){
                ans = rans+1;
                maxPath = Math.max(maxPath,ans);
                return rans+1;
            }
        }else if(root.left==null){
            
            if(root.val==root.right.val){
                maxPath = Math.max(maxPath,rans+1);
                return rans+1;
            }
        }else if(root.right==null){
            if(root.val==root.left.val){
                maxPath = Math.max(maxPath,lans+1);
                return lans+1;
            }
        }
        return 0; // start frm U.
    }
    
    public int longestUnivaluePath(TreeNode root) {
        maxPath = 0;
        longestUVP(root);
        return maxPath;
    }
}