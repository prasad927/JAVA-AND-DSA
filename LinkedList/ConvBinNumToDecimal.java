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
 //Convert Binary Number in a Linked List to Integer
class ConvBinNumToDecimal{
    
    public int getDecimalValueHelp(ListNode head,int[] base){
            
            if(head==null){
                return 0;
            }
            if(head.next==null){
                return head.val*base[0];
            }
            
            int res = getDecimalValueHelp(head.next,base);
            base[0]=base[0]*2;
            res=res+(head.val)*base[0];
            return res;
        
    }
    
    public int getDecimalValue(ListNode head) {
           
           int[] base = {1};
           int res = getDecimalValueHelp(head,base);
           return res;
    }
}