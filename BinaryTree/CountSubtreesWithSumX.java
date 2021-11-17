/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/


class CountSubtreesWithSumX{
    
    int countSubtreesWithSumX(Node root,int X,int[] ans){
        if(root==null){
            return 0;
        }
        
        if(root.left==null && root.right==null){
            if(root.data==X){
                ans[0]++;
            }
            
            return root.data;
        }
        
        int lsum = countSubtreesWithSumX(root.left,X,ans);
        int rsum = countSubtreesWithSumX(root.right,X,ans);
        
        if(lsum+rsum+root.data==X){
            ans[0]++;
        }
        
        return lsum+rsum+root.data;
    }
    int countSubtreesWithSumX(Node root, int X){
	   int [] ans = {0};
	   int sum = countSubtreesWithSumX(root,X,ans);
	   return ans[0];
    }
}