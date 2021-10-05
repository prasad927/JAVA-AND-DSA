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
class MergeTwoSortedLL{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null ? l2:l1;
        }
        
        
        ListNode res = new ListNode(-1);
        ListNode rtail = res;
        
        while(l1!=null && l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            
            if(val1<val2){
                rtail.next = l1;
                l1 = l1.next;
            }else{
                rtail.next = l2;
                l2 = l2.next;
            }
            rtail = rtail.next;
        }
        
        if(l1!=null){
            rtail.next = l1;
        }else{
            rtail.next = l2;
        }
        
        return res.next;
    }
}