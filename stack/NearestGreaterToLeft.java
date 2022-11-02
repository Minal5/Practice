package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		int[] ans = NGL(arr,4);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] NGL(int[] arr,int n) {
		Stack<Integer> s = new Stack<>();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(s.size() == 0) {
				a.add(-1);
			}
			else if(s.size()>0 && s.peek()>arr[i]) {
				a.add(s.peek());
			} 
			else if(s.size()>0 && s.peek() <= arr[i]) {
				while(s.size()>0 && s.peek() <= arr[i]) {
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
		int idx=0;
		int[] ans = new int[a.size()];
		for(int x:a) {
			ans[idx++] = x;
		}
		return ans;
	}
	
}
