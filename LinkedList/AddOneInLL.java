/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class AddOneInLL{
    public static int addOneHelper(Node node){
        
        if(node.next==null){
            int newData = node.data+1;
            node.data = newData%10;
            return newData/10;
        }
        
        int carry = addOneHelper(node.next);
        
        int newData = carry+node.data;
        node.data = newData%10;
        return newData/10;
    }
    
    public static Node addOne(Node head){ 
        int carry = addOneHelper(head);
        
        if(carry>0){
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        
        return head;
    }
}
