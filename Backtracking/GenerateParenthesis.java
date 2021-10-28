
// Using backtracking only:
class GenerateParenthesis{
    
    public boolean isValid(String exp){
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char curr = exp.charAt(i);
            
            if(curr=='('){
                st.push(curr);
            }else if(curr==')'){
                
                if(st.size()==0){
                    st.push(curr);
                }else if(st.peek()=='('){
                    st.pop();
                }else if(st.peek()==')'){
                    st.push(curr);
                }
            }
        }
        
        return st.size()==0 ? true : false;
    }
    
    public void generateParenthesis(String exp,int pairs,int open,int close,List<String> ansList){
        
        if(open==pairs&& close==pairs){
            // System.out.println(exp);
            if(isValid(exp)){
                String nans = exp;
                ansList.add(nans);
            }
            return;
        }
        
        if(close<pairs){
             String nexpc = exp+")";
             generateParenthesis(nexpc,pairs,open,close+1,ansList);
        }
        
        if(open<pairs){
             String nexpo = exp+"(";
             generateParenthesis(nexpo,pairs,open+1,close,ansList);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ansList = new ArrayList<>();
        generateParenthesis("(",n,1,0,ansList);
        return ansList;
    }
}