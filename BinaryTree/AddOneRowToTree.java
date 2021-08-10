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
class AddOneRowToTree{
    
    private void addOneRow_(TreeNode root,int val,int depth){
        
        if(root==null){
            return;
        }
        
        if(depth==1){
            //reach to given pos
            TreeNode lnode = new TreeNode(val);
            TreeNode rnode = new TreeNode(val);
            
            lnode.left = root.left;
            rnode.right = root.right;
            
            root.left = lnode;
            root.right = rnode;
            return;
        }
        
        addOneRow_(root.left,val,depth-1);
        addOneRow_(root.right,val,depth-1);
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
    
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }       
        addOneRow_(root,val,depth-1);
        return root;
    }
}