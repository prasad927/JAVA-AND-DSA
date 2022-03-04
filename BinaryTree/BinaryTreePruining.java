/************************************************
    Binary Tree Node class for reference

    class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
            left = right = null;
        }

    };

    You have been given a Binary Tree where the value of each node is either 0 or 1. 
    Your task is to return the same Binary Tree but all of its subtrees that don't contain
    a 1 have been removed.
 **********************************************/
    
public class BinaryTreePruning {
    public static int helper(BinaryTreeNode root){
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            return root.val;
        }
        
        int lsum = helper(root.left);
        if(lsum==0){
            root.left=null;
        }
        
        int rsum = helper(root.right);
        if(rsum==0){
            root.right=null;
        }
        
        return root.val+lsum+rsum;
    }
    public static BinaryTreeNode binaryTreePruning(BinaryTreeNode root){
        if(root==null){
            return null;
        }
        
        int sum = helper(root);
        if(sum==0){
            return null;
        }
        return root;
    }

}
