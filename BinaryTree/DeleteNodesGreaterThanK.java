


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class DeleteNodesGreaterThanK{
        public Node deleteNode(Node root,int k){
              
              if(root==null){
                  return null;
              }
              
              if(root.data>=k){
                  root.right=null;//dis-card right side
                  root.left=deleteNode(root.left,k);
                  //delete root also
                  return root.left;
                  
              }else if(root.data<k){
                  root.right=deleteNode(root.right,k);
              }
              
              return root;
         }
}