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
// Using recursion.
class PalindromeLL {
    ListNode left;
    public boolean isPalindromeHelper(ListNode temp){
        
        if(temp==null){
            return true;
        }
        boolean res = isPalindromeHelper(temp.next);
        
        if(res==false){
            return false;
        }else{
             if(left.val==temp.val){
                 left=left.next;
                 return true;
             }else{
                 return false;
             }
        }
    }
    public boolean isPalindrome(ListNode head) {
         left=head;
         return isPalindromeHelper(head);
    }
}