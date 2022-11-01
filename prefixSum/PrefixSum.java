package prefixSum;

import java.util.Arrays;

public class PrefixSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] ans = runningSum(nums);
		System.out.println(Arrays.toString(ans));
		System.out.println(sumLtoR(nums,1,3));
	}

	//https://leetcode.com/problems/running-sum-of-1d-array/
	public static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1] + nums[i];
        }
        return ans;
    }
	
	//here l and r is given that means we have to find the sum of elements in certain range
	public static int sumLtoR(int[] nums,int l,int r) {
		int ans = 0;
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for(int i = 1;i<nums.length;i++) {
			sum[i] = sum[i-1] + nums[i];
		}
		if(l == 0) return sum[r];
		ans = sum[r] - sum[l-1];
		return ans;
	}
}
