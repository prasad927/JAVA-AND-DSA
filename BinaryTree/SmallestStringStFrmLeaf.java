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
class SmallestStringStFrmLeaf{
    
    String mans;
    public void smallestFromLeafHelp(TreeNode root,String ans){
        if(root==null){
            return;
        }
        
        char curr = (char) (root.val+97);
        if(root.left==null && root.right==null){
            ans = curr+ans;
            if(mans.length()==0){
                mans = ans;
            }else{
                int len1 = ans.length();
                int len2 = mans.length();
                int minlen = Math.min(len1,len2);
                
                for(int i=0;i<minlen;i++){
                    char ch1 = ans.charAt(i);
                    char ch2 = mans.charAt(i);
                    
                    if(ch1!=ch2){
                        if(ch1<ch2){
                            mans = ans;
                            return;
                        }else if(ch1>ch2){
                            mans = mans;
                            return;
                        }
                    }
                }
                
                // take lexicographically smallest
                mans = minlen == len1 ? ans : mans;
            }
        }
        smallestFromLeafHelp(root.left,curr+ans);
        smallestFromLeafHelp(root.right,curr+ans);
    }
    
    
    public String smallestFromLeaf(TreeNode root) {
        mans = "";
        smallestFromLeafHelp(root,"");
        return mans;
    }
}