class DecodeWays{
    private void numDecodingsHelp(String s,int[] count,HashMap<String,Integer> map){
        if(s.length()==0){
            count[0]++;
            return;
        }
        
        if(s.charAt(0)=='0'){
            return;
        }
        
        if(map.containsKey(s)){
            count[0]+=map.get(s);
            return;
        }
        
        for(int i=0;i<s.length();i++){
            
            String num = s.substring(0,i+1);
            String rest = s.substring(i+1);
            int nnum = Integer.parseInt(num);
            if(nnum>26){
                break;
            }
            numDecodingsHelp(rest,count,map);
        }
        map.put(s,count[0]);
        
    }
    
    public int numDecodings(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int[] count ={0};
        // System.out.println(s.length());
        numDecodingsHelp(s,count,map);
        return count[0];
    }
}