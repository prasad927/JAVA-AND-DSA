/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class HouseRobber3{
    
    //RECURSIVE SLOW SOLUTION 
   /* private int rob_(TreeNode root,boolean state,HashMap<String,Integer> map){
        
        
        
        if(root==null){
            return 0;
        }
        
        String s = root.toString()+state;
        
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        
        if(state==false){
            //rob or not rob
            
            //rob
            int rob = root.val;
            rob+=rob_(root.left,true,map);
            rob+=rob_(root.right,true,map);
            // not rob
            int nrob = rob_(root.left,false,map);
            nrob+=rob_(root.right,false,map);
            int res=Math.max(rob,nrob);
            map.put(s,res);
            return res;
        }else{
            //not rob
            int res= rob_(root.left,false,map)+rob_(root.right,false,map);
            map.put(s,res);
            return res;
        }
    }*/
    
    public int rob(TreeNode root){
        
        //HashMap<String,Integer> map = new HashMap<>();
        //return rob_(root,false,map);
        
        int[] res = rob_(root);
        return Math.max(res[0],res[1]);
        
    }
    //0--->withRob
    //1--->withoutRob
    public int[] rob_(TreeNode root){
        
        
        if(root==null){
            return new int[] {0,0};
        }
        
        int[] lans = rob_(root.left);
        int[] rans = rob_(root.right);
        int[] ans = new int[2];
        ans[0]=root.val+lans[1]+rans[1];
        ans[1]=Math.max(lans[0],lans[1])+Math.max(rans[0],rans[1]);
        return ans;
    }
}