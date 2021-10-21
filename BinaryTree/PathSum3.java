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
class PathSum3{
    int count;
    private void pathSum(TreeNode root,int tarsum,int currsum,HashMap<TreeNode,Boolean> track){
        
        if(root==null){
            return;
        }
        if(currsum+root.val==tarsum){
            
            count++;
        }
        
        pathSum(root.left,tarsum,currsum+root.val,track);
        pathSum(root.right,tarsum,currsum+root.val,track);
        
        if(track.containsKey(root)==false){
          track.put(root,true);
          pathSum(root.left,tarsum,0,track);
          pathSum(root.right,tarsum,0,track);
        }
    } 
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<TreeNode,Boolean> track = new HashMap<>();
        count=0;
        pathSum(root,targetSum,0,track);
        return count;
    }
}