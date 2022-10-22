package slidingWindow;

import java.util.HashMap;

public class PickToys {

	public static void main(String[] args) {
		String s = "abaccab";
		System.out.println(pickToys(s));
	}

	public static int pickToys(String s) {
		int mx=0;
		int i=0,j=0;
		HashMap<Character,Integer> map = new HashMap<>();
		while(j < s.length()) {
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0)+1);
			if(map.size() < 2) j++;
			else if(map.size() == 2) {
				mx = Math.max(mx, j-i+1);
				j++;
			}
			else {
				while(map.size() > 2) {
					char c= s.charAt(i);
					map.put(c,map.getOrDefault(c, 0)-1);
					if(map.get(c)==0) {
						map.remove(c);
					}
					i++;
				}
				if(map.size() == 2) {
					mx = Math.max(mx, j-i+1);
				}
				j++;
			}
		}
		return mx;
	}
}
