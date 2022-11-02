package stack;
//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextLargest {

	public static void main(String[] args) {
		int n=4;
		long[] arr = {1,3,2,4};
		long[] ans = nextLargerElement(arr,n);
		System.out.println(Arrays.toString(ans));
	}

	public static long[] nextLargerElement(long[] arr, int n)
    { 
       ArrayList<Long> a=new ArrayList<>();
       Stack<Long> s=new Stack<>();
       
       for(int i=n-1;i>=0;i--) {
    	   if(s.size() == 0) {
    		   a.add((long) -1);
    	   }
    	   else if(s.size() > 0 && s.peek()>arr[i]) {
    		   a.add(s.peek());
    	   }
    	   else if(s.size() > 0 && s.peek() <= arr[i]) {
    		   while(s.size() > 0 && s.peek() <= arr[i]) {
    			   s.pop();
    		   }
    		   if(s.size() == 0) {
    			   a.add((long) -1);
    		   }
    		   else {
    			   a.add(s.peek());
    		   }
    	   }
    	   s.push(arr[i]);
       }
       Collections.reverse(a);
       int idx = 0;
		long[] ans = new long[a.size()];
		for(long value:a) {
			ans[idx++] = value;
		}
		return ans;
		
    }
}
