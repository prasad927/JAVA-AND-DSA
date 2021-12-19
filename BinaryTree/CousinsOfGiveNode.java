// CousinsOfGivenode

//User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution{
    static ArrayList<Integer> ans;
                                    //flag
    public static void fillList(Node root,Node flag,int level){
        
         if(root==null || root.equals(flag)){
             return;
         }
         
         if(level==0){
             ans.add(root.data);
             return;
         }
         
         fillList(root.left,flag,level-1);
         fillList(root.right,flag,level-1);
    }
    
    public static int printCousinsHelp(Node root,Node node_to_find){
         if(root==null){
             return -1;
         }
         
         if(root.equals(node_to_find)){
            //  System.out.println("NODE WAS FOUND");
             return 1;
         }
         
         
         int lstatus = printCousinsHelp(root.left,node_to_find);
         if(lstatus==1){
             //child is node to find
             return 1+1;
         }else if(lstatus>=2){
             fillList(root.right,root.left,lstatus-1);//go to right
             return lstatus+1;
         }
         
         int rstatus = printCousinsHelp(root.right,node_to_find);
         
         if(rstatus==1){
             return 1+1;
         }else if(rstatus>=2){
             fillList(root.left,root.right,rstatus-1); //go to right.
             return rstatus+1;
         }
         
         return -1;
    }
    
    
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find){
         ans = new ArrayList<Integer>();
         printCousinsHelp(root,node_to_find);
         
         if(ans.size()==0){
             ans.add(-1);
         }
         
         Collections.sort(ans); //this will be avoided
         return ans;
    }
}