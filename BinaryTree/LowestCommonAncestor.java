class LowestCommonAncestor{

    public ArrayList<TreeNode> rootToNodePath(TreeNode root,TreeNode node){
        if(root==null){
            return new ArrayList<>();
        }
        
        if(root.val==node.val){
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        
        ArrayList<TreeNode> lres = rootToNodePath(root.left,node);
        
        if(lres.size()>0){
            lres.add(root);
            return lres;
        }
        ArrayList<TreeNode> rres = rootToNodePath(root.right,node);
        
        if(rres.size()>0){
            rres.add(root);
            return rres;
        }
        
        return new ArrayList<>();
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
        ArrayList<TreeNode> ppath = rootToNodePath(root,p);
        ArrayList<TreeNode> qpath = rootToNodePath(root,q);
        
        int i=ppath.size()-1;
        int j=qpath.size()-1;
        
        while(i>=0 && j>=0){
            TreeNode pnode = ppath.get(i);
            TreeNode qnode = qpath.get(j);
            
            if(pnode.val!=qnode.val){
                return ppath.get(i+1);
            }
            
            i--;
            j--;
        }
        return ppath.get(i+1);
    }
}