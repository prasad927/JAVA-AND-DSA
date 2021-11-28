/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class MinimumDepthOfABinaryTree{
    
    public void minDepth(Node root,int[] minDepth,int depth){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            if(depth<minDepth[0]){
                minDepth[0] = depth;
            }
            return;
        }
        
        minDepth(root.left,minDepth,depth+1);
        minDepth(root.right,minDepth,depth+1);
    }
    
	int minDepth(Node root){
	    int[] minDepth = {Integer.MAX_VALUE};
	    minDepth(root,minDepth,1);
	    return minDepth[0];
	}
}