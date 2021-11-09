
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
class FindLargestValueInEachTreeRow{
    //using DFS
    public void largestValuesHelp(TreeNode root,int level,List<Integer> list){
        if(root==null){
            return;
        }
        
        if(list.size()==level){
            list.add(Integer.MIN_VALUE);
        }
        
        list.set(level,Math.max(list.get(level),root.val));
        largestValuesHelp(root.left,level+1,list);
        largestValuesHelp(root.right,level+1,list);
    }
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        largestValuesHelp(root,0,list);
        return list;
    }
}