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
class AddTwoNumbers1{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        int carry=0;
        ListNode ans = new ListNode(-1);
        ListNode ptr3 = ans;
        
        while(carry!=0 || ptr1!=null || ptr2!=null){
            int v1 = (ptr1==null) ? 0:ptr1.val;
            int v2 = (ptr2==null) ? 0:ptr2.val;
            
            int sum = v1+v2+carry;
            carry=sum/10;
            sum=sum%10;
            
            ListNode digit = new ListNode(sum);
            ptr3.next=digit;
            
            ptr3 = ptr3.next;
            ptr1= (ptr1==null) ? null : ptr1.next;
            ptr2= (ptr2==null) ? null : ptr2.next;
        }
        
        ListNode temp=ans;
        ans=ans.next;
        temp.next=null;
        return ans;
    }
}