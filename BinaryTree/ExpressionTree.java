/* A Tree node is defined as
class Node
{
    String data;
    Node left,right;

    Node(String data)
     {
     this.data = data;
     this.left = null;
     this.right = null;
     }

}*/

class Solution {
    public int evalTree(Node root) {
        
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return Integer.parseInt(root.data);
        }
        
        int lres = evalTree(root.left);
        int rres = evalTree(root.right);
        
        char op=root.data.charAt(0);
        
        if(op=='+'){
            return lres+rres;
        }else if(op=='-'){
            return lres-rres;
        }else if(op=='*'){
            return lres*rres;
        }else{
            return lres/rres;
        }
    }
}/* A Tree node is defined as
class Node
{
    String data;
    Node left,right;

    Node(String data)
     {
     this.data = data;
     this.left = null;
     this.right = null;
     }

}*/

class ExpressionTree{
    public int evalTree(Node root) {
        
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return Integer.parseInt(root.data);
        }
        
        int lres = evalTree(root.left);
        int rres = evalTree(root.right);
        
        char op=root.data.charAt(0);
        
        if(op=='+'){
            return lres+rres;
        }else if(op=='-'){
            return lres-rres;
        }else if(op=='*'){
            return lres*rres;
        }else{
            return lres/rres;
        }
    }
}