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

public class RemoveDuplicatesInSortedList{
       
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode temp = head;
        
        while(temp.next!=null){
            ListNode nxt = temp.next;
            
            if(temp.val==nxt.val){
                temp.next=nxt.next;
                nxt.next=null;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
}