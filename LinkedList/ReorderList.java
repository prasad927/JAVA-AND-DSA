//L0 → L1 → … → Ln - 1 → Ln
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
class ReorderList{
    public ListNode getMid(ListNode head){
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    public ListNode reverse(ListNode head){
        
        if(head.next==null){
            return head;
        }
        
        ListNode prev=null;
        ListNode curr = head;
        ListNode nxt=null;
    
        while(curr!=null){
            nxt = curr.next;
            curr.next=prev;
            
            prev = curr;
            curr = nxt;
        }
        
        return prev;
    }
    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null){
            return;
        }
        
        ListNode midOfLL = getMid(head);
        ListNode nhead = midOfLL.next;
        midOfLL.next=null;
        nhead = reverse(nhead);
        
        ListNode ptr1 = head;
        ListNode ptr2 = nhead;
    
        while(ptr2!=null){
            ListNode temp1 = ptr1.next;
            ListNode temp2 = ptr2.next;
            
            ptr1.next = ptr2;
            ptr2.next = temp1;
            
            ptr1 = temp1;
            ptr2 = temp2;
        }
    }
}