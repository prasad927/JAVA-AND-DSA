/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class BinaryTreeToCDLL{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        if(root==null){
            return null;
        }
        
        if(root.left==null && root.right==null){
            root.right = root;
            root.left=root;
            return root;
        }
        
        Node lhead = bTreeToClist(root.left);
        Node rhead = bTreeToClist(root.right);
        
        if(lhead!=null && rhead!=null){
            Node ltail = lhead.left;
            Node rtail = rhead.left;
            
            ltail.right = root;
            root.left = ltail;
            root.right = rhead;
            rhead.left = root;
            
            lhead.left = rtail;
            rtail.right = lhead;
            
            return lhead;
            
        }else if(lhead==null){
            Node rtail = rhead.left;
            root.right = rhead;
            rhead.left = root;
            
            root.left = rtail;
            rtail.right = root;
            return root;
        }else{
            Node ltail = lhead.left;
            ltail.right=root;
            root.left = ltail;
            lhead.left=root;
            root.right=lhead;
            return lhead;
        }
    }
}
    