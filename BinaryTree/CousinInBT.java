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
class CousinInBT{
    
    private ArrayList<TreeNode> rootToNodePath(TreeNode root,int data){
        if(root==null){
            return new ArrayList<>();
        }
        
        if(root.val==data){
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        
        ArrayList<TreeNode> lans = rootToNodePath(root.left,data);
        if(lans.size()>0){
            lans.add(root);
            return lans;
        }
        
        ArrayList<TreeNode> rans = rootToNodePath(root.right,data);
        if(rans.size()>0){
            rans.add(root);
            return rans;
        }
        return new ArrayList<>();
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
         ArrayList<TreeNode> xpath = rootToNodePath(root,x);
         ArrayList<TreeNode> ypath = rootToNodePath(root,y);
        
         if(xpath.size()!=ypath.size() || xpath.size()==2 && ypath.size()==2){
             return false;
         }
         
         TreeNode xp = xpath.get(1);
         TreeNode yp = ypath.get(1);
        
         if(xp.equals(yp)){
             return false;
         }
         return true;
    }
}