/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*reverse the nodes of the list from position left to position right, 
and return the reversed list.*/
class ReverseLL2{
    public ListNode reverseBetween(ListNode head, int left, int right){
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        int count=1;
        
        while(count!=left){
            prev=curr;
            curr=curr.next;
            count++;
        }
        //start reversing from here which nodes belongs to left--right
        ListNode prev2 = null;
        ListNode tail2 = curr;
        ListNode nxt = null;
        while(count!=right){
            nxt = curr.next;
            curr.next = prev2;
            
            prev2 = curr;
            curr = nxt;
            count++;
        }
        nxt = curr.next;
        curr.next = prev2;
        
        if(prev==null){
           tail2.next = nxt;
           return curr;//new head curr is last node where right points
        }else{
            prev.next = curr;
            tail2.next=nxt;
            return head;
        }  
    }
}