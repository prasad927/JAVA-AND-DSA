/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class CountUnivalueSubtrees{

    private int countUnivalSubtrees(TreeNode root,int[] ans){
        if(root==null){
			return 1;
		}
		
		if(root.left==null && root.right==null){
			ans[0]++;
			return 1; //status
		}
		
		int lres = countUnivalSubtrees(root.left,ans);
		int rres = countUnivalSubtrees(root.right,ans);
		
		if(root.left!=null && root.right!=null){
			if(lres!=-1 && rres!=-1 && root.left.val==root.val && root.right.val==root.val){
				ans[0]++;
			}else{
				return -1; // for mis-match
			}
		}else if(root.left!=null){
			if(lres!=-1 && root.left.val==root.val){
				ans[0]++;
			}else{
				return -1;
			}
		}else if(root.right!=null){
			if(rres!=-1 && root.right.val==root.val){
				ans[0]++;
			}else{
				return -1;
			}
		}
        		
		return 1;
    }

    public int countUnivalSubtrees(TreeNode root) {
        int[] ans={0};
		countUnivalSubtrees(root,ans);
		return ans[0];
    }
}