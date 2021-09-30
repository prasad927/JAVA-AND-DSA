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
class EvenOddTree{
    public boolean isEvenOddTree(TreeNode root) {
        ArrayDeque<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);
        int level = 0;
        while(bfs.size()!=0){
            int currsize = bfs.size();
            int prev = -1;
            //check for current level
            while(currsize!=0){
                TreeNode rem = bfs.remove();
                
                if(level%2==0 && rem.val%2==0){
                    return false;
                }
                
                if(level%2!=0 && rem.val%2!=0){
                    return false;
                }
                
                //check for strictly inc.. dec
                
                if(level%2==0){
                    if(prev==-1){
                        prev = rem.val;
                    }else{
                        if(prev>=rem.val){
                            return false;
                        }else{
                            prev = rem.val;
                        }
                    }
                }
                
                
                if(level%2!=0){
                    if(prev==-1){
                        prev = rem.val;
                    }else{
                        if(prev<=rem.val){
                            return false;
                        }else{
                            prev = rem.val;
                        }
                    }
                }
                
            
                if(rem.left!=null){
                    bfs.add(rem.left);
                }
                
                if(rem.right!=null){
                    bfs.add(rem.right);
                }
                currsize--;
            }
            level++;
        }
        return true;
    }
}