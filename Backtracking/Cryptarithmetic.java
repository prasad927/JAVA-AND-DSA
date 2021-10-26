//Cryptarithmetic

import java.io.*;
import java.util.*;

public class Cryptarithmetic{

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }
  
  public static int getDigit(String str,HashMap<Character, Integer> charIntMap){
      int num = charIntMap.get(str.charAt(0));
      
      for(int i=1;i<str.length();i++){
          char ch = str.charAt(i);
          num = num*10+charIntMap.get(ch);
      }
      
      return num;
  }
  
  public static void solution(String unique, int idx,HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,String s1, String s2, String s3) {
	   
	    if(idx==unique.length()){
	        
	        int num1 = getDigit(s1,charIntMap);
	        int num2 = getDigit(s2,charIntMap);
	        int num3 = getDigit(s3,charIntMap);
	        
	        if(num1+num2==num3){
	            for(int i=0;i<26;i++){
	                char ch = (char) (97+i);
	                Integer mapVal = charIntMap.get(ch);
	                
	                if(mapVal!=null){
	                    System.out.print(ch+"-"+mapVal+" ");
	                }
	            }
	            System.out.println();
	        }
	        
	        return;
	    }
	    char ch = unique.charAt(idx);
	    
	    //map with used digit.
	    for(int digit=0;digit<=9;digit++){
	        if(usedNumbers[digit]==false){
	            //try to map
	            usedNumbers[digit] = true;
	            charIntMap.put(ch,digit);
	            solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
	            usedNumbers[digit] = false;
	            charIntMap.put(ch,-1);
	        }
	    }
  }

}
