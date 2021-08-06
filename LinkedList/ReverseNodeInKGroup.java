public class ReverseNodeInKGroup{

    private ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode nxt = null;
        
        while(curr!=null){
            nxt = curr.next;
            curr.next=prev;
            
            prev = curr;
            curr = nxt;
        }
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k){
        
        if(head==null || head.next==null || k==0){
            return head;
        }
    
        int tempK = k-1;//to run loop only k-1 time
        
        ListNode temp = head;
        //temp!=null for checking for if k is larger than size of LL then it gives NPE
        //to avoid this we do this and if this case occur then direct return head from
        //here no need to reverse
        while( temp!=null && tempK>0){
            temp = temp.next;
            tempK--;
        }
        
        if(temp!=null){
            ListNode temphead = temp.next;
            temp.next = null;//break
            ListNode rhead = reverse(head);
            ListNode rtail = rhead;
            
            while(rtail.next!=null){
                rtail=rtail.next;
            }
            rtail.next = reverseKGroup(temphead,k);//call next for recursively
            return rhead;
            
        }else{
            return head;
        }
    }
}