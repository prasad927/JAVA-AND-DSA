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
class SwappingNodesInLL{
    public ListNode swapNodes(ListNode head, int k) {
         
        
        int tempK = k;
        ListNode fast = head;
        ListNode slow = head;
        ListNode help1 = null;
        while(tempK>1){
            fast = fast.next;
            tempK--;
        }
        help1 = fast;
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        int val = help1.val;
        help1.val = slow.val;
        slow.val = val;
        
        return head;
    }
}