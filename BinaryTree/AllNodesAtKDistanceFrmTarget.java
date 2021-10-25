/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AllNodesAtKDistanceFrmTarget{
    
    public void distanceKNodes(TreeNode root,TreeNode block,int k,List<Integer> ansList){
        if(k<0|| root==null || root==block){
            return;
        }
        
        if(k==0){
            ansList.add(root.val);
            return;
        }
        
        distanceKNodes(root.left,block,k-1,ansList);
        distanceKNodes(root.right,block,k-1,ansList);
    }
    
    public int findTargetAndGetDistanceKNodes(TreeNode root,TreeNode target,int k,List<Integer> ansList){
        if(root==null){
            return -1;
        }
        
        if(root.equals(target)){
            //target found
            distanceKNodes(root,null,k,ansList);
            return 1;
        }
        
        
        int lresp = findTargetAndGetDistanceKNodes(root.left,target,k,ansList);
        if(lresp>0){
            distanceKNodes(root,root.left,k-lresp,ansList);
            return lresp+1;
        }
        
        int rresp = findTargetAndGetDistanceKNodes(root.right,target,k,ansList);
        if(rresp>0){
            distanceKNodes(root,root.right,k-rresp,ansList);
            return rresp+1;
        }
        
        return -1;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ansList = new ArrayList<>();
        findTargetAndGetDistanceKNodes(root,target,k,ansList);
        return ansList;
    }
}