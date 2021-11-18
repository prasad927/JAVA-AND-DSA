
/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class SumOfLeafNodesAtMinLevel{
    public void minLeafSum(Node root,int level,int[] minLLS){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(level==minLLS[0]){
                minLLS[1]+=root.data;
            }else if(level<minLLS[0]){
                //minLevel
                minLLS[0]=level;
                minLLS[1]=root.data;
            }
            return;
        }
        
        minLeafSum(root.left,level+1,minLLS);
        minLeafSum(root.right,level+1,minLLS);
    }
    
    public int minLeafSum(Node root){
        //[level,sum]
        int[] minLLS = {Integer.MAX_VALUE,0};
        minLeafSum(root,1,minLLS);
        return minLLS[1];
    }
}