package stack;
//https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NearestSmallerToRight {

	public static void main(String[] args) {
		int[] arr = {3, 8, 5, 2, 25};
		int[] ans = help_classmate(arr,5);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] help_classmate(int arr[], int n) 
	{ 
		ArrayList<Integer> a=new ArrayList<>();
	       Stack<Integer> s=new Stack<>();
	       
	       for(int i=n-1;i>=0;i--) {
	    	   if(s.size() == 0) {
	    		   a.add(-1);
	    	   }
	    	   else if(s.size() > 0 && s.peek()<arr[i]) {
	    		   a.add(s.peek());
	    	   }
	    	   else if(s.size() > 0 && s.peek() >= arr[i]) {
	    		   while(s.size() > 0 && s.peek() >= arr[i]) {
	    			   s.pop();
	    		   }
	    		   if(s.size() == 0) {
	    			   a.add(-1);
	    		   }
	    		   else {
	    			   a.add(s.peek());
	    		   }
	    	   }
	    	   s.push(arr[i]);
	       }
	       Collections.reverse(a);
	       int idx = 0;
			int[] ans = new int[a.size()];
			for(int value:a) {
				ans[idx++] = value;
			}
			return ans;
	} 
	
}
