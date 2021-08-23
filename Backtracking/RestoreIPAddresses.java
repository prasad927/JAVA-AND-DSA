class RestoreIPAddresses{
    
    public void restoreIpAddressesHelp(String num,String ansf,int dots,List<String> list){
        
        if(dots==0){
            
            if(num.length()==1){
                ansf=ansf+num;
                list.add(ansf);
            }else{
                if(num.length()>0 && num.length()<=3 && Integer.parseInt(num)<=255 && num.charAt(0)!='0'){
                   ansf=ansf+num;
                   list.add(ansf);
                 }
            }
            return;
            
        }
        
        for(int i=0;i<num.length();i++){
            String fp = num.substring(0,i+1);
            String sp = num.substring(i+1);
            
            if(fp.length()<=3){
                
                if(fp.length()==1){
                    String nansf=ansf+fp+".";
                    restoreIpAddressesHelp(sp,nansf,dots-1,list);
                }else{
                    
                    if(Integer.parseInt(fp)<=255 && fp.charAt(0)!='0'){
                         String nansf=ansf+fp+".";
                         restoreIpAddressesHelp(sp,nansf,dots-1,list);
                    }
                }

            }else{
                return;
            }
        }
        
    }     
    public List<String> restoreIpAddresses(String s) {
        
        if(s.length()==0){
            return new ArrayList<>();
        }       
        List<String> list = new ArrayList<>();
        restoreIpAddressesHelp(s,"",3,list);
        
        return list;
    }
}