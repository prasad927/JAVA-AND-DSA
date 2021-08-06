
public class SwapNodeInPairs{
    
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        
        
        ListNode temp = head.next.next; //storing the next-next node for recursion call
        
        head.next.next = head; //pointing next node pointer on self
        
        head = head.next; // move head to next node
        
        head.next.next = swapPairs(temp); // catching result in second node of pair i.e last node in pair
        
        return head; // returning updated head
    }
}