
class MaximumNumOfWordsYouCanType{
    public int canBeTypedWords(String text, String brokenLetters) {
        
        
        boolean[] brokenChars = new boolean[26];
        
        for(int i=0;i<brokenLetters.length();i++){
            char curr = brokenLetters.charAt(i);
            int idx = (int)(curr-97);
            brokenChars[idx]=true;
        }
        
        int count=0;
        
        for(int i=0;i<text.length();){
             
             boolean isBroken = false;
             while(i<text.length() && text.charAt(i)!=' '){
                 char curr = text.charAt(i);
                 int idx = (int)(curr-97);
                 
                 if(brokenChars[idx]==true){
                     isBroken=true;
                 }
                 i++;
             }  
             if(isBroken==false){
                 count++;
             }
             i++;
        }
        return count;
    } 
}