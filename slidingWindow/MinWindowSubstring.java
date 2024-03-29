package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	 public static String minWindow(String s, String t) {	        
	        Map<Character, Integer> map = new HashMap<>();
	        for(char ch: t.toCharArray())
	            map.put(ch, map.getOrDefault(ch, 0) + 1);	        
	        int count = map.size(), ansLength = Integer.MAX_VALUE;
	        String ans = "";	        
	        int i = 0, j = 0;
	        while(j < s.length()) {            
	            char cur = s.charAt(j);
	            if(map.containsKey(cur)) {
	                map.put(cur, map.get(cur) - 1);
	                if(map.get(cur) == 0) count--;
	            }
	            
	            if(count > 0)
	                j++;
	            
	            else if(count == 0) {                    
	                while(count == 0) {                    
	                    if(j-i+1 < ansLength) {
	                        ansLength = j-i+1;
	                        ans = s.substring(i, j+1);
	                    }	                    
	                    char rm = s.charAt(i);
	                    if(map.containsKey(rm)) {
	                        map.put(rm, map.get(rm) + 1);
	                        if(map.get(rm) == 1) count++;
	                    }  	                    
	                    i++;    
	                }  	                
	                j++;  
	            }
	        }	        
	        return ans;
	 }
}
