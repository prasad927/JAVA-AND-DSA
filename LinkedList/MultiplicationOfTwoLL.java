import java.util.*;
public class MultiplicationOfTwoLL{

    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverseLL(ListNode head){

        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=null;

        while(curr!=null){
            nxt=curr.next;
            curr.next = prev;

            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public static ListNode multiplyOneNode(ListNode head,ListNode node,int count){

        ListNode temp = head;
        ListNode res = new ListNode(-1);
        ListNode p3 = res;
        int carry=0;
        while(temp!=null){
            int ans = (temp.val*node.val)+carry;

            carry=ans/10;
            ans = ans%10;
            ListNode nd = new ListNode(ans);
            p3.next = nd;
            temp=temp.next;
            p3 = p3.next;
        }

        if(carry>0){
            ListNode nd = new ListNode(carry);
            p3.next = nd;
        }

        ListNode temp1 = res;
        res = res.next;
        temp1.next=null;
        //for trailing zero
        while(count>0){
            ListNode nd = new ListNode(0);
            nd.next = res;
            res=nd;
            count--;
        }

        res = reverseLL(res);
        return res;
    }
    public static ListNode addList(ListNode l1,ListNode l2){

        ListNode ans = new ListNode(-1);
        ListNode p1 = reverseLL(l1);
        ListNode p2 = reverseLL(l2);
        ListNode p3 = ans;
        int carry=0;

        while(carry!=0 || p1!=null || p2!=null){
            int v1 = (p1==null) ? 0:p1.val;
            int v2 = (p2==null) ? 0:p2.val;
            int sum = v1+v2+carry;

            carry = sum/10;
            sum=sum%10;
            p3.next = new ListNode(sum);

            p3 = p3.next;
            p1 = (p1==null) ? null:p1.next;
            p2 = (p2==null) ? null:p2.next;
        }
        ListNode temp = ans;
        ans = ans.next;
        temp.next=null;
        ans = reverseLL(ans);
        return ans;
    }
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2){

        ListNode p1 = reverseLL(l1);
        ListNode p2 = reverseLL(l2);
        int count=0;
        ListNode ans=null;
        while(p2!=null){
            ListNode res = multiplyOneNode(p1,p2,count);

            if(ans==null){
                ans=res;
            }else{
                ans = addList(ans,res);
            }
            p2=p2.next;
            count++;
        }
        return ans;
    }

    // Input_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }
}