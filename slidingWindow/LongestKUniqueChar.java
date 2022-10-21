package slidingWindow;
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

import java.util.HashMap;

public class LongestKUniqueChar {

	public static void main(String[] args) {
		String S = "aabacbebebe";
		int K = 3;
		System.out.println(longestkSubstr(S,K));
	}
	
	public static int longestkSubstr(String s, int k) {
        int mx = -1;
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()) {
        	char ch = s.charAt(j);
        	map.put(ch, map.getOrDefault(ch,0)+1);
        	if(map.size() < k) j++;
        	else if(map.size() == k) {
        		mx = Math.max(mx, j-i+1);
        		j++;
        	}
        	else {
        		while(map.size() > k) {
        			char c = s.charAt(i);
        			map.put(c, map.get(c)-1);
        			if(map.get(c)==0) {
        				map.remove(c);
        			}
        			i++;
        			if(map.size() == k) {
        				mx = Math.max(mx, j-i+1);
        			}
        		}
        		j++;
        	}
        }
		return mx;
    }

}
