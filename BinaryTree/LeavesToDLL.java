
//User function Template for Java

/*
Node is as follows:
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

class LeavesToDLL{
    // return the head of the DLL and remove those node from the tree as well.
    private Node DLLH;
    private Node DLLT;
    private Node convertToDLLHelp(Node root){
        if(root==null){
            return null;
        }
        
        if(root.left==null && root.right==null){
            if(DLLH==null){
                DLLH=root;
                DLLT=root;
            }else{
                DLLT.right = root;
                root.left = DLLT;
                DLLT = root;
            }
            return null;
        }
        
        root.left=convertToDLLHelp(root.left);
        root.right=convertToDLLHelp(root.right);
        
        return root;
    }
    
    public Node convertToDLL(Node root){
        DLLH=null;
        DLLT=null;
        convertToDLLHelp(root);
        return DLLH;
    }
    
}