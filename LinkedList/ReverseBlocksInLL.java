
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class ReverseBlocksInLL{
	
	public static Node helper(Node head,int[] blocks,int idx){

		if(idx==b.length){
			return head;
		}

		if(head==null || head.next==null){
			return head;
		}
		
		int blockSize=blocks[idx];
		
        //imp check
		if(blockSize==0){
            return helper(head,b,idx+1);
        }
		
		Node prev=null;
		Node curr = head;
		Node nxt=null;
		
		while(blockSize!=0 && curr!=null){
			nxt = curr.next;
			curr.next=prev;
			
			prev = curr;
			curr = nxt;
			blockSize--;
		}
		
		head.next = helper(curr,blocks,idx+1);
		return prev;
	}
    
    /*
    Linked list: 1->2->3->4->5
    Array of blocks sizes: 3 3 5
    Output: 3->2->1->5->4*/
	
	public static Node getListAfterReverseOperation(Node head, int n, int blocks[]) {
		 return helper(head,b,0);
	}
}