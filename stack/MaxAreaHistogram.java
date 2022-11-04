package stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.*;

public class MaxAreaHistogram {

	public static void main(String[] args) {
		int[] heights = {2,3};
		System.out.println(largestRectangleArea(heights));
	}

	public static int largestRectangleArea(int[] heights) {  
		int[] left = nsl(heights);
		int[] right = nsr(heights);
		int[] width = new int[heights.length];
		int max = 0;
		for(int i=0;i<heights.length;i++) {
			width[i] = right[i] - left[i] - 1;
		}
		for(int i =0;i<heights.length;i++) {
			max = Math.max(width[i] * heights[i],max);
		}
		return max;
    }
  
	public static int[] nsr(int[] heights) {
		int[] right=new int[heights.length];
		Stack<Pair> s = new Stack<>();
		int pseudo = heights.length;
		for(int i=heights.length-1;i>=0;i--) {
			while(s.size() > 0 && s.peek().first >= heights[i]) {
				s.pop();
			}
			if(s.size() == 0)
				right[i] = pseudo;
			else 
				right[i] = s.peek().second;
			s.push(new Pair(heights[i],i));
		}
		Collections.reverse(Arrays.asList(right));
		return right;
	}
  
	public static int[] nsl(int[] heights) {
		int[] left=new int[heights.length];
		Stack<Pair> s = new Stack<>();
		int pseudo = -1;
		for(int i=0;i<heights.length;i++) {
		    while(s.size() > 0 && s.peek().first >= heights[i]) {
				s.pop();
			}
			if(s.size() == 0)
				left[i] = pseudo;
			else 
				left[i] = s.peek().second;
			s.push(new Pair(heights[i],i));
		}
		return left;
	}
	
	static class Pair {
		int first;
		int second;
		Pair(int first,int second){
			this.first = first;
			this.second = second;
		}
	}
}
