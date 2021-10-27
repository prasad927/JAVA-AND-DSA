class WordBreak{
    
    public boolean wordBreakHelp(String s,List<String> wordDict,HashMap<String,Boolean> map){
         
         if(s.length()==0){
             return true;
         }
    
         if(map.containsKey(s)){
             // System.out.println("OK");
             return map.get(s);
         }
         
         for(int i=0;i<s.length();i++){
             String prefix = s.substring(0,i+1);
             
             for(String str : wordDict){
                 if(str.equals(prefix)){
                     //call
                     String ros=s.substring(i+1);
                     boolean res=wordBreakHelp(ros,wordDict,map);
                     if(res){
                         map.put(s,true);
                         return res;
                     }
                 }
             }
         }
         map.put(s,false);
         return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> map = new HashMap<>();
        return wordBreakHelp(s,wordDict,map);
    }
}