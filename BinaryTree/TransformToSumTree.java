/*
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class TransformToSumTree{
    
    private int toSumTreeHelp(Node root){
        
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            int rootval = root.data;
            root.data=0;
            return rootval;
        }
        
        int lsum = toSumTreeHelp(root.left);
        int rsum = toSumTreeHelp(root.right);
        int rootval = root.data;
        root.data = lsum+rsum;
        return lsum+rsum+rootval;
    }
    public void toSumTree(Node root){
         
         
         toSumTreeHelp(root);
    }
}