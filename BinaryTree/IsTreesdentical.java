/*

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/


class IsTreesIndentical
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{     
	      if(root1==null && root2!=null){
	          return false;
	      }
	      if(root1!=null && root2==null){
	          return false;
	      }
	      if(root1==null && root2==null){
	          return true;
	      }
	      if(root1.data!=root2.data){
	          return false;
	      }
	      
	      boolean lres = isIdentical(root1.left,root2.left);
	      if(lres==false){
	          return false;
	      }
	      boolean rres = isIdentical(root1.right,root2.right);
	      if(rres==false){
	          return false;
	      }
	      return true;
	}
	
}