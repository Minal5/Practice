package stack;
//https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeft {

	public static void main(String[] args) {
	
	}
	
	public static List<Integer> leftSmaller(int n, int a[])
    {
		List<Integer> ans= new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<n;i++) {
			if(s.size() == 0) {
				ans.add(-1);
			}
			else if(s.size()>0 && s.peek()<a[i]) {
				ans.add(s.peek());
			} 
			else if(s.size()>0 && s.peek() >= a[i]) {
				while(s.size()>0 && s.peek() >= a[i]) {
					s.pop();
				}
				if(s.size() == 0) {
					ans.add(-1);
				}
				else {
					ans.add(s.peek());
				}
			}
			s.push(a[i]);
		}
		return ans;
    }

}
