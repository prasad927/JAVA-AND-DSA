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
class OddEvenLL{
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode oddLLptr = null;
        ListNode evenLLptr = null;
        ListNode oddLLhead = null;
        ListNode evenLLhead = null;
        ListNode temp = head;
        int count=1;
        while(temp!=null){
            
            if(count%2!=0){
                //even
                if(oddLLptr==null){
                    oddLLhead=temp;
                    oddLLptr=temp;
                }else{
                    oddLLptr.next=temp;
                    oddLLptr=oddLLptr.next;
                }
            }else{
                //odd
                if(evenLLptr==null){
                    evenLLhead=temp;
                    evenLLptr=temp;
                }else{
                    evenLLptr.next=temp;
                    evenLLptr=evenLLptr.next;
                }
            }
            temp = temp.next;
            count++;
        }
        evenLLptr.next = null;
        oddLLptr.next = evenLLhead;

        return oddLLhead;
    }
}