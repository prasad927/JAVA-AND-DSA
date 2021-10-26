
class SplitStringIntoTheMaxNumberOfUniqueSubstrings{
    
    int max;
    public void maxUniqueSplit_(String s,HashSet<String> container){
        if(s.length()==0){
            //check
            if(max<container.size()){
                max = container.size();
            }
            return;
        }
        
        for(int i=0;i<s.length();i++){
            String prev = s.substring(0,i+1);
            String rest = s.substring(i+1);
            
            if(container.contains(prev)==false){
                container.add(prev);
                maxUniqueSplit_(rest,container);
                container.remove(prev); // backtrack
            }
        }
    }
    
    public int maxUniqueSplit(String s) {
        max = 0;
        HashSet<String> contn = new HashSet<>();
        maxUniqueSplit_(s,contn);
        return max;
    }
}