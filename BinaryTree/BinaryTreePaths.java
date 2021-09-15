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
class BinaryTreePaths{
    public List<String> binaryTreePaths(TreeNode root) {
        
            if(root==null){
                return new ArrayList<>();
            }
        
            if(root.left==null && root.right==null){
                List<String> list = new ArrayList<>();
                list.add(root.val+"");
                return list;
            }
            List<String> ans = new ArrayList<>();
            List<String> lres =binaryTreePaths(root.left);
            for(String s:lres){
                ans.add(root.val+"->"+s);
            }
            List<String> rres =binaryTreePaths(root.right);
        
            for(String s:rres){
                ans.add(root.val+"->"+s);
            }
            return ans;
    }
}