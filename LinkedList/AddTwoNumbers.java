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
class AddTwoNumbers{
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        
        ListNode temp1 = l1;
        
        while(temp1!=null){
            st1.push(temp1);
            temp1 = temp1.next;
        }
        temp1 = l2;
        while(temp1!=null){
            st2.push(temp1);
            temp1=temp1.next;
        }
        int carry=0;
        ListNode anshead = null;
        while(st1.size()>0 || st2.size()>0 || carry!=0){
            
            int val1 = st1.size()==0 ? 0:st1.pop().val;
            int val2 = st2.size()==0 ? 0:st2.pop().val;
            
            int sum = val1+val2+carry;
            carry = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            
            if(anshead==null){
                anshead = node;
            }else{
                node.next = anshead;
                anshead = node;
            }
        }
        return anshead;
    }
}