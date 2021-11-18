//Maximum Node Level

/*
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}

Given a Binary tree. Find the level in binary tree which has the maximum number of nodes.
*/

class Tree{

    public static void maxNodeLevel(Node root,ArrayList<Integer> track,int level,int[] max){
        if(root==null){
            return;
        }
        
        if(track.size()==level){
            track.add(0);
        }
        
        track.set(level,track.get(level)+1);
        
        if(track.get(level)==track.get(max[0])){
            max[0] = Math.min(level,max[0]);
        }else{
            max[0] = track.get(level) > track.get(max[0]) ? level : max[0];
        }
        
        maxNodeLevel(root.left,track,level+1,max);
        maxNodeLevel(root.right,track,level+1,max);
    }
    
    public static int maxNodeLevel(Node root){
        ArrayList<Integer> track = new ArrayList<>();
        int[] max = {0};
        maxNodeLevel(root,track,0,max);
        return max[0];//level
    }
}