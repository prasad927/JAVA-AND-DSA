import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class Pair{
        TreeNode node;
        int level;
        
        Pair(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void width(TreeNode root,int[] minMax,int currHL){
        if(root==null){
            return;
        }
        
        minMax[0]= Math.min(minMax[0],currHL);
        minMax[1]= Math.max(minMax[1],currHL);
        
        width(root.left,minMax,currHL-1);
        width(root.right,minMax,currHL+1);
    }
    public static ArrayList<Integer> TopView(TreeNode root) {
        
        if(root==null){
            return new ArrayList<>();
        }
        int[] minMax = {0,0};
        width(root,minMax,0);
        
        int maxWidth = minMax[1]-minMax[0]+1;
        ArrayList<Integer> ans  = new ArrayList<>();
        
        for(int i=0;i<maxWidth;i++){
            ans.add(null);
        }
        
        //RUN BSF
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair(root,Math.abs(minMax[0]-0)));
        
        while(q.size()!=0){
            int currsize = q.size();
            
            while(currsize!=0){
                Pair curr = q.removeFirst();
                TreeNode node = curr.node;
                int level = curr.level;
                
                if(ans.get(level)==null){
                    ans.set(level,node.val);
                }
                
                if(node.left!=null){
                    q.add(new Pair(node.left,level-1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,level+1));
                }
                currsize--;
            }
        } 
        return ans;
    }
}