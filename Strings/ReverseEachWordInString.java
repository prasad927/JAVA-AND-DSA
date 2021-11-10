
//using stack
class ReverseEachWordInString{
   
    String reverseWords(String S){
        String ans ="";
        Stack<Character> hlp = new Stack<>();
        for(int i=0;i<S.length();i++){
            char curr = S.charAt(i);
            if(curr=='.'){
                while(hlp.size()>0){
                    ans+=hlp.pop();
                } 
                hlp=new Stack<>();
                ans+=curr;
            }else{
                hlp.push(curr);
            }
        }
        while(hlp.size()>0){
            ans+=hlp.pop();
        }
        return ans;
    }
}