
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}*/

class PrintNodesHavingKLeaves{
    public int btWithKleavesHlp(Node root,int k,ArrayList<Integer> list){
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            return 1;
        }
        
        int lresp = btWithKleavesHlp(root.left,k,list);
        int rresp = btWithKleavesHlp(root.right,k,list);
        
        if(lresp+rresp==k){
            list.add(root.data);
        }
        
        return lresp+rresp;
    }
    
    public ArrayList<Integer> btWithKleaves(Node root, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        btWithKleavesHlp(root,k,ans);
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
}