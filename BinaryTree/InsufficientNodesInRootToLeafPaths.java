
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
class InsufficientNodesInRootToLeafPaths{
    
    private TreeNode sufficientSubset(TreeNode root,int sum,int limit){
        
        if(root==null){
            return null;
        }
        
        if(root.left==null && root.right==null){
            //check at leaf and return ans accordingly if sum not expected to limit then return null else return root
            sum+=root.val;
            
            if(sum<limit){
                return null;
            }else{
                return root;
            }
        }
        sum+=root.val;//update sum
        
        root.left = sufficientSubset(root.left,sum,limit);
        root.right = sufficientSubset(root.right,sum,limit);
        
        //check in post order
        if(root.left==null && root.right==null){
                return null;
        }  
        return root;
    }
    
    public TreeNode sufficientSubset(TreeNode root, int limit){
        return sufficientSubset(root,0,limit);
    }
}