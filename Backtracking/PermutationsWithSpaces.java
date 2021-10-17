class PermutationsWithSpaces{
       
    void permutationhelp(String s,ArrayList<String> ans,String ansf){
        
        if(s.length()==0){
            ans.add(ansf);
            return;
        }
        
        if(s.length()==1){
            permutationhelp("",ans,ansf+s);
        }else{
            char curr = s.charAt(0);
            String ros = s.substring(1);
            
            //Two options give space after currChar and not give space after curr-char
            permutationhelp(ros,ans,ansf+curr+" ");
            permutationhelp(ros,ans,ansf+curr);
        }
        
    }
    
    public ArrayList<String> permutation(String S){
        ArrayList<String> ans = new ArrayList<>();
        permutationhelp(S,ans,"");
        return ans;
    }
}