class DeleteLeafWithGivVal{
         
    public TreeNode removeLeafNodes(TreeNode root, int target) {
            
        if(root==null){
            return null;
        }
        
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        
    //check root in post order that isRoot also converted to leaf 
    // and if root has val==target then remove root also
        if(root.left==null && root.right==null && root.val==target){
            return null;
        }
        
        return root;
    }
}