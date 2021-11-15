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

// Brute force
class RotateList{
    public static int length(ListNode temp){
        
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
            
            if(head==null){
                return null;
            }
        
            if(head.next==null){
                return head;
            }
            int len = length(head);
            k=k%len;
            for(int i=0;i<k;i++){
                ListNode temp = head;
                
                while(temp.next.next!=null){
                    temp = temp.next;
                }
                
                ListNode nh = temp.next;
                temp.next=null;
                nh.next = head;
                head=nh;
            }
        
            return head;
    }
}