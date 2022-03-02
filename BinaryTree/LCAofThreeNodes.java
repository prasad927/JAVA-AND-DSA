/**********************************************************
	Following is the Binary Tree Node class.

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
		this.data = data;
	    }
	}
	
***********************************************************/

public class LCAofThreeNodes {
    static BinaryTreeNode<Integer> ans;
    public static int helper(BinaryTreeNode<Integer> root,int node1,int node2,int node3){
        if(root==null){
            return 0;
        }
        
        int count=0;
        int val=root.data;
        if(val==node1){
            count++;
        }
        
        if(val==node2){
            count++;
        }
        
        if(val==node3){
            count++;
        }
        
        int lstatus = helper(root.left,node1,node2,node3);
        int rstatus = helper(root.right,node1,node2,node3);
        
        
        if((count+lstatus+rstatus)==3 && ans==null){
            ans = root;
        }


        return count+lstatus+rstatus;
    }
    
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
         	ans=null;
            helper(root,node1,node2,node3);
            return ans;
    }
}