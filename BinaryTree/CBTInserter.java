
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
class CBTInserter{
    
    private TreeNode CBTRoot;
    private LinkedList<TreeNode> queue;
    private TreeNode actionPoint;
    
    ///////////////////////////////////////////////////////////////////////////////
    public CBTInserter(TreeNode root) {
        this.CBTRoot = root;
        this.queue = new LinkedList<>();
        
        setActionPoint();
    }
    
    private void setActionPoint(){
      
        queue.addLast(this.CBTRoot);
        
        while(queue.size()!=0){
            TreeNode rmv = queue.removeFirst();
            
            if(rmv.left!=null){
                queue.addLast(rmv.left);
            }else{
                this.actionPoint=rmv;
                break;
            }
            
            if(rmv.right!=null){
                queue.addLast(rmv.right);
            }else{
                this.actionPoint=rmv;
                break;
            }
        }
    }
    
    public int insert(int val) {
        
        TreeNode root = new TreeNode(val);
        int rval = this.actionPoint.val;
        if(this.actionPoint.left==null){
            this.actionPoint.left = root;
            queue.addLast(root);
        }else{
            this.actionPoint.right = root;
            queue.addLast(root);
    
            //Assign to actionPoint to next node
            this.actionPoint=queue.removeFirst();
        }
        return rval;
    }
    
    public TreeNode get_root() {
        return this.CBTRoot;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */