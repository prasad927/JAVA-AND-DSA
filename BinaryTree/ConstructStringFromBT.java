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
class ConstructStringFromBT{
    public String tree2str(TreeNode t) {
         if(t==null){
             return "";
         }    
        
         if(t.left==null && t.right==null){
             String ans =t.val+"";
             return ans;
         }         
        
         String lans = tree2str(t.left);
         String rans = tree2str(t.right);
        
         lans = "("+lans+")";
         
         if(rans.length()!=0){
            rans = "("+rans+")";
         }
         
         return t.val+lans+rans;
         
         
    }
}