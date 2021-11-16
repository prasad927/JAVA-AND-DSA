

/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

*/

//Remove node which has only one child.
class RemoveHalfNodes{
    // Return the root of the modified tree after removing all the half nodes.
    public static Node RemoveHalfNodes(Node root){
        
        if(root.left==null && root.right==null){
            return root;
        }
        int count=0;   
        
        if(root.left!=null){
            //call
            root.left = RemoveHalfNodes(root.left);
            count++;
        }
        
        if(root.right!=null){
            root.right = RemoveHalfNodes(root.right);
            count++;
        }
        r.
        //check and delete
        if(count==1){
            return root.left==null ? root.right : root.left;
        }
        
        return root;
    }
}
