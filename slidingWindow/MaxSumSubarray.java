package slidingWindow;

public class MaxSumSubarray {

	public static void main(String[] args) {
		int[] nums= {1, 4, 2, 10, 23, 3, 1, 0, 20};
		System.out.println(maxSubArray(nums,4));
	}

	public static int maxSubArray(int[] nums,int k) {
        
		int j = 0;
		int i=0;
		int sum = 0;
		int mx = Integer.MIN_VALUE; 
		while(j<nums.length) {
			sum = sum + nums[j];
			if(j-i+1 < k)	j++;
			else if(j-i+1 == k) {
				mx=Math.max(sum, mx);
				sum = sum - nums[i];
				i++;
				j++;
			}
		}
		return mx;
    }
}
