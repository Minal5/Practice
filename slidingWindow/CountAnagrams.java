package slidingWindow;
//https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountAnagrams {

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s,p));
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list= new ArrayList<>();
		HashMap<Character,Integer> h=new HashMap<>();
		for(int i=0;i<p.length();i++){
            if(!h.containsKey(p.charAt(i)))
                h.put(p.charAt(i),1);
            else{
                h.put(p.charAt(i),h.get(p.charAt(i))+1);
            }
        }
		int count = h.size();
		int i = 0, j = 0;
		int k = p.length();
		while(j<s.length()) {
			//calculations
			char t=s.charAt(j);
			if(h.containsKey(t)){
				h.put(t, h.get(t) - 1);
				if(h.get(t) == 0) count--;
			}	
			if((j-i+1)<k) j++;
			else if(j-i+1 == k) {
				if(count == 0) {
					list.add(i);	
				}
				if(h.containsKey(s.charAt(i))) {
					h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
					if(h.get(s.charAt(i))==1)count++;
				}
				i++;
				j++;
			}
		}
		return list;
    }

}
