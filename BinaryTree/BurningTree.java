import java.util.*;

public class Main {

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  static int maxTime = 0;
  
  public static void burningTree_(TreeNode root,TreeNode blocked,int time){
      
        if(root==null || root==blocked){
            return;
        }
        
        maxTime = Math.max(maxTime,time);
        
        burningTree_(root.left,blocked,time+1);
        burningTree_(root.right,blocked,time+1);
  }
  
  public static int burningTreeHelp(TreeNode root,int firenode){
       if(root==null){
            return -1;
        }
        
        if(root.val==firenode){
            //first node from burning starts.
            burningTree_(root,null,0);
            return 1;
        }
        
        int ltime = burningTreeHelp(root.left,firenode);
        
        if(ltime!=-1){
            //buring start in left child
            burningTree_(root,root.left,ltime);
            return ltime+1;
        }
        
        int rtime = burningTreeHelp(root.right,firenode);
        
        if(rtime!=-1){
            //burning start in right child
            burningTree_(root,root.right,rtime);
            return rtime+1;
        }
        
        return -1; // firenode not found in left or right of curr root
  }
  
  public static int burningTree(TreeNode root, int fireNode) {
      burningTreeHelp(root,fireNode);
      return maxTime;
  }
}