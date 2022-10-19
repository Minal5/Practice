package slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxOfSubarray {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] ans = maxSlidingWindow(nums,k);
		System.out.println(Arrays.toString(ans));
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] ans = new int[nums.length-k+1];
		int i=0,j=0,p=0;
		Deque<Integer> dq = new ArrayDeque<>();
		while(j<nums.length) {
			//Calculations
			//check if deque has any element smaller than nums[j]
			//if present then remove that element and than add nums[j]
			while(dq.size() > 0 && dq.peekLast() < nums[j]) {
                dq.pollLast();
            }
            dq.addLast(nums[j]);
			
			if((j-i+1) < k) j++;
			else if((j-i+1) == k) {
				ans[p++] = dq.peekFirst();
                if(dq.peekFirst() == nums[i]) 
                    dq.pollFirst();
				
				i++;
				j++;
			}
		}
		
		return ans;
    }

}

