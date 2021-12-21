/*
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class DeleteAlternateNodes{
    
    public void deleteAlternate (Node head){
        
        Node temp = head;
        
        while(temp!=null&& temp.next!=null){
            Node nxt = temp.next;
            temp.next = nxt.next;
            nxt.next = null;
            
            temp = temp.next;
        }
    }
}