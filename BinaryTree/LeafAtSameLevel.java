

//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class LeafAtSameLevel{
    private boolean checker(Node root,int[] prevLL,int level){
        if(root==null){
            return true;
        }
        
        if(root.left==null && root.right==null){
            //check level. and return acc.
            if(prevLL[0]==-1 || prevLL[0]==level){
                prevLL[0]=level;
                return true;
            }
            
            return false;
        }
        
        if(!checker(root.left,prevLL,level+1)){
            return false;
        } 
        
        if(!checker(root.right,prevLL,level+1)){
            return false;
        }
        
        return true;
    }
    
    boolean check(Node root){
	    int[] prevLL = {-1};
	    return checker(root,prevLL,0);
    }
}
