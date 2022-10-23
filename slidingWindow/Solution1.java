//https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

class Solution1 {
    public int minimumRecolors(String blocks, int k) {
        int m=0;
		int i=0,j=0;
		HashMap<Character,Integer> map = new HashMap<>();
		while(j < blocks.length()) {
			char ch = blocks.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0)+1);
            if(j-i+1 < k) j++;
            else if(j-i+1 == k){
                m = Math.max(m , map.getOrDefault('B',0));
                char c= blocks.charAt(i);
				map.put(c,map.getOrDefault(c, 0)-1);
				if(map.get(c)==0) {
					map.remove(c);
				}
				i++;
                j++;
            }
        }
         return k - m;   
    }
}
