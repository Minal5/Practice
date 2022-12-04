package potd;

public class MinAvgDifference {

	public static void main(String[] args) {
		int[] nums = {2,5,3,9,5,3};
		System.out.println(minimumAverageDifference(nums));
	}
	
	public static int minimumAverageDifference(int[] nums) {
        int n = nums.length; 
        int ans = -1;
        int minDiff = Integer.MAX_VALUE;
        
        long presum = 0;
        long sum = 0;
        
        for(int s : nums ) {
        	sum +=s;
        }
        
        for(int i=0;i<n;i++) {
        	presum += nums[i];
        	long lavg = presum/(i+1);
        	long ravg = (sum-presum);
        	if(i != n-1) {
        		ravg /= (n-i-1); 
        	}
        	int diff = (int)Math.abs(lavg - ravg);
        	if(diff < minDiff) {
        		ans = i;
        		minDiff = diff;
        	}
        }
        
        return ans;
    }

}
