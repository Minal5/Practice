package potd;

import java.util.*;

public class FindPlayers {

	public static void main(String[] args) {
		
	}

	public static List<List<Integer>> findWinners(int[][] matches) {
		 Map<Integer, Integer> map = new HashMap<>();
	        
	        for (int[] match: matches) {
	            map.putIfAbsent(match[0], 0);
	            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
	        }
	        
	        List<Integer> allWin = new ArrayList<>();
	        List<Integer> allWinExceptOne = new ArrayList<>();
	        for (Integer key: map.keySet()) {
	            int value = map.get(key);
	            
	            if (value == 0) {
	                allWin.add(key);
	            } else if (value == 1) {
	                allWinExceptOne.add(key);
	            }
	        }
	        
	        Collections.sort(allWin);
	        Collections.sort(allWinExceptOne);
	        
	        return List.of(allWin, allWinExceptOne);
    }
	
}
