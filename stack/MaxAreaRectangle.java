package stack;
//https://leetcode.com/problems/maximal-rectangle/description/

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaxAreaRectangle {

	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
							{'1','0','1','1','1'},
							{'1','1','1','1','1'},
							{'1','0','0','1','0'}};
		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int[] a = new int[m];
		for(int j=0;j<m;j++) {
			a[j] = matrix[0][j] - '0';
		}
		int mx = MAH(a);
		for(int i=1;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(matrix[i][j] == '0')
					a[j] = 0;
				else
					a[j] = a[j] + (matrix[i][j]-'0');
			}
			mx = Math.max(mx, MAH(a));
		}
		return mx;
    }

	public static int MAH(int[] heights) {
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
