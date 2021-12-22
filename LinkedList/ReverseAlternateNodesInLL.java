
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class ReverseAlternateNodesInLL{
    public static void rearrange(Node odd){
         
         if(odd.next==null){
             return;
         }
         
        // Approach :-> reverse alternate nodes in single parse.
         
         Node orderListPtr = odd;
         Node toReversePtr = odd.next;
         Node temp = toReversePtr.next;
         Node prev = null;
         
         
         //break connc.
         orderListPtr.next = null;
         toReversePtr.next = prev;
         prev = toReversePtr;
         
         int count=2;
         while(temp!=null){
             if(count%2==0){
                //  direct connc.
                orderListPtr.next = temp;
                orderListPtr = temp;
                temp = temp.next;
             }else{
                Node curr = temp;
                temp = curr.next;
                
                //set
                curr.next = prev;
                prev = curr;
             }
             
             count++;
         }
        
         orderListPtr.next = prev; //connect;
    }
}