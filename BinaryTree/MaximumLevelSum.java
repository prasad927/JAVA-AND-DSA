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
class MaximumLevelSum{
    //MODIFY TO DFS
    public void maxLevelSum(TreeNode root,int level,ArrayList<Integer> store){
        if(root==null){
            return;
        }
        
        if(store.size()==level){
            store.add(0);
        }
        store.set(level,store.get(level)+root.val);
        maxLevelSum(root.left,level+1,store);
        maxLevelSum(root.right,level+1,store);
        
    }
    
    public int maxLevelSum(TreeNode root) {
       /* 
        Queue<TreeNode> mainq = new ArrayDeque<>();
        int maxsum = Integer.MIN_VALUE;
        int maxSumLvl=0;
        mainq.add(root);
        int level=1;
        
        while(mainq.size()!=0){
            
            int currsize = mainq.size();
            int currsum = 0;
            
            while(currsize!=0){
                TreeNode node = mainq.remove();
                currsum+=node.val;
                
                if(node.left!=null){
                    mainq.add(node.left);
                }
                
                if(node.right!=null){
                    mainq.add(node.right);
                }
                currsize--;
            }
            
            if(currsum>maxsum){
                maxsum=currsum;
                maxSumLvl=level; 
            }
            level++;
        }
        return maxSumLvl;*/
         
        ArrayList<Integer> store = new ArrayList<>();
        maxLevelSum(root,0,store);
        int maxSumLvl=0;
        int maxSum=Integer.MIN_VALUE;
        
        for(int i=0;i<store.size();i++){
            int currsum = store.get(i);
            
            if(maxSum<currsum){
                maxSum=currsum;
                maxSumLvl=i;
            }
        }
        
        return maxSumLvl+1;
    }
}