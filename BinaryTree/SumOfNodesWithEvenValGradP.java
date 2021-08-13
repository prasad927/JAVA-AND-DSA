//Sum of nodes with even valued grandparent
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
class SumOfNodesWithEvenValGradP{
    private int sumEvenGrandparent(TreeNode root,TreeNode parent,TreeNode grandP){
        
        if(root==null){
            return 0;
        }
        
        if(grandP==null){
            //simlpe calls and deciding grand parents
            //if current node dont have grand parent then simple return result given by its childs

            int lres = sumEvenGrandparent(root.left,root,parent);
            int rres = sumEvenGrandparent(root.right,root,parent);
            
            return lres+rres;
        }else{
            //decide gr*and parents
            int lres = sumEvenGrandparent(root.left,root,parent);
            int rres = sumEvenGrandparent(root.right,root,parent);
            
            //if current node have its grand parent then check grand parent and return ans accordingly
            if(grandP.val%2==0){
                return lres+rres+root.val;
            }else{
                return lres+rres;
            }
            
        }
        
    }
    public int sumEvenGrandparent(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            return 0;
        }
        
        int ans = sumEvenGrandparent(root.left,root,null);
        ans += sumEvenGrandparent(root.right,root,null);
        
        return ans;
    }
}