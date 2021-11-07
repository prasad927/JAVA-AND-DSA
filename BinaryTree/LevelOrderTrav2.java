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
class LevelOrderTrav2{
    public void levelOrderBottomHelp(TreeNode root,int depth,List<List<Integer>> mainans){
        if(root==null){
            return;
        }
        
        if(depth==mainans.size()){
            List<Integer> list = new ArrayList<>();
            mainans.add(list);
        }
        
        mainans.get(depth).add(root.val);
        levelOrderBottomHelp(root.left,depth+1,mainans);
        levelOrderBottomHelp(root.right,depth+1,mainans);
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> mainans = new ArrayList<>();
        levelOrderBottomHelp(root,0,mainans);
        
        Collections.reverse(mainans);
        return mainans;
    }
}