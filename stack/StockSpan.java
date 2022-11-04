package stack;
//https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int[] arr = {100,80,60,70,60,75,85};
		int n=7;
		int[] ans = stock(arr,n);
		System.out.println(Arrays.toString(ans));
	}

	static class Pair{
	      int first;
	      int second;
	      Pair(int first,int second){
	          this.first = first;
	          this.second = second;
	      }
	  }
	
	public static int[] stock(int[] arr,int n) {
		Stack<Pair> s = new Stack<>();
		int[] ans=new int[n];
		
		for(int i =0;i<n;i++) {
			if(s.size() == 0) {
				ans[i] = -1;
			}
			else if(s.size()>0 && s.peek().first > arr[i]) 
				ans[i] = s.peek().second;
			else if(s.size()>0 && s.peek().first <= arr[i]) {
				while(s.size()>0 && s.peek().first <= arr[i]) {
					s.pop();
				}
				if(s.size()==0)
					ans[i] = -1;
				else
					ans[i] = s.peek().second;
			}
			s.push(new Pair(arr[i],i));
		}
		for(int i=0;i<n;i++) {
			ans[i] = i-ans[i];
		}
		return ans;
	}
	
}
