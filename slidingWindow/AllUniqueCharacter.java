package slidingWindow;

import java.util.HashMap;

public class AllUniqueCharacter {

	public static void main(String[] args) {
		String s = "abbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int mx = 0;
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j < s.length()) {
        	char ch = s.charAt(j);
        	map.put(ch,map.getOrDefault(ch, 0)+1 );
        	if(map.size() == j-i+1) {
        		mx = Math.max(mx, j-i+1);
        		j++;
        	}
        	else if(map.size() < j-i+1) {
        		char c = s.charAt(i);
        		map.put(c, map.get(c)-1);
        		if(map.get(c) == 0) {
        			map.remove(c);
        		}
        		i++;
        		if(map.size() == j-i+1) {
        			mx= Math.max(mx, j-i+1);
        		}
        		j++;
        	}
        }
        
        return mx;
    }

}
