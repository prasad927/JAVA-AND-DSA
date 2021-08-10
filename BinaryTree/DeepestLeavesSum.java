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
class DeepestLeavesSum{
    
    private void deepestLeavesSum(TreeNode root,int[] dtrack,int[] sum,int currdepth){
        
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            
            if(dtrack[0]<currdepth){
                //**********assigning new depth******
                sum[0]=root.val;
                dtrack[0]=currdepth;
            }else if(dtrack[0]==currdepth){
                //*******keeping old depth*******
                //and modify sum with previous same depth sum of root
                sum[0]+=root.val;
            }
        }

        deepestLeavesSum(root.left,dtrack,sum,currdepth+1);
        deepestLeavesSum(root.right,dtrack,sum,currdepth+1);    
        
    }
    
    public int deepestLeavesSum(TreeNode root) {
        
        int[] dtrack = new int[1];
        dtrack[0]=-1;//to track deepth of tree
        int[] sum = new int[1];
        sum[0]=0;
        
        deepestLeavesSum(root,dtrack,sum,0);
        return sum[0];
    }
}