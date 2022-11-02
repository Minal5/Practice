package stack;
//https://leetcode.com/problems/next-greater-element-i/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] ans = nextGreaterElement(nums1,nums2);
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer,Integer> h = new HashMap<>();
		Stack<Integer> s = new Stack<>();
		
		for(int i=nums2.length-1;i>=0;i--) {
			if(s.size() == 0) {
				h.put(nums2[i], -1);
			}
			else if(s.size() > 0 && s.peek()>nums2[i]) {
				h.put(nums2[i], s.peek());
			}
			else if(s.size() > 0 && s.peek()<=nums2[i]) {
				while(s.size() > 0 && s.peek()<=nums2[i]) {
					s.pop();
				}
				if(s.size()==0) {
					h.put(nums2[i], -1);
				}else {
					h.put(nums2[i], s.peek());
				}
			}
			s.push(nums2[i]);
		}
		int[] ans = new int[nums1.length];
		for(int i = 0;i<nums1.length;i++) {
			ans[i]=h.get(nums1[i]);
		}
		return ans;
	}

}
