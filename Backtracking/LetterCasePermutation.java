class LetterCasePermutation{
    
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder helper = new StringBuilder(s);
        helper(helper,0,ans);
        return ans;
    }
    public void helper(StringBuilder sb,int curr,List<String> ans){
        
        if(curr==sb.length()){
            ans.add(sb.toString());
            return;
        }
        char ch = sb.charAt(curr);
        if(ch>='0' && ch<='9'){
            //no change
            helper(sb,curr+1,ans);
        }else if(ch>='A' && ch<='Z'){
            
            helper(sb,curr+1,ans);
            char newch = (char) (ch+32);
            sb.setCharAt(curr,newch);
            helper(sb,curr+1,ans);
            sb.setCharAt(curr,ch); //back-track
        }else if(ch>='a' && ch<='z'){
            
            helper(sb,curr+1,ans); 
            char newch = (char)(ch-32);
            sb.setCharAt(curr,newch);
            helper(sb,curr+1,ans);
            sb.setCharAt(curr,ch);//back-track
        }
    }
}