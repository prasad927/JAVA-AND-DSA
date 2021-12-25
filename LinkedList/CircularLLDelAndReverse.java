/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/
class CircularLLDelAndReverse{
    //This method returns the head of the LL after deleting node with value d.
    public static Node deleteNode(Node head,int d){
        if(head.data==d){
            return head;
        }
        
        Node temp = head;
        Node prev = null;
        while(temp.next!=head){
            if(temp.data==d){
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        
        if(temp.next==head){
            return head;
        }
        
        prev.next = temp.next;
        temp.next = null;
        
        return head;
    }
    //This method returns the head node of the reversed Linked list.
    public static Node reverse(Node head){
         Node temp = head;
         Node prev = null;
         while(temp.next!=head){
             Node nxt = temp.next;
             temp.next = prev;
             
             prev = temp;
             temp = nxt;
         }
         
         temp.next = prev;
         head.next = temp;
         
         return temp;
    }
}