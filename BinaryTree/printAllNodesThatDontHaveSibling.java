

//User function Template for Java

/*  A Binary Tree nodea
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
class printAllNodesThatDontHaveSibling{
    void noSiblingHelper(Node node,ArrayList<Integer> list){
        
        if(node==null){
            return;
        }
        
        
        noSiblingHelper(node.left,list);
        noSiblingHelper(node.right,list);
        
        if(node.left==null && node.right==null){
            return;
        }else if(node.left==null){
            list.add(node.right.data);
        }else if(node.right==null){
            list.add(node.left.data);
        }
        
    }
    ArrayList<Integer> noSibling(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        noSiblingHelper(node,list);
        Collections.sort(list);
        
        if(list.size()==0){
            list.add(-1);
        }
        return list;
    }
}