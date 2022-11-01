package prefixSum;

public class PivotIndex {

	public static void main(String[] args) {
		int[] nums = {1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));
	}

  //https://leetcode.com/problems/find-pivot-index/
	public static int pivotIndex(int[] nums) {
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            total +=nums[i];
        }
        int lsum = 0;
        for(int i=0;i<nums.length;i++){
            if(i != 0 ) lsum += nums[i-1];
            if(total - lsum - nums[i]== lsum){
                return i;
            }
        }
        return -1;
    }
  
  //Both the questions are same
  //https://leetcode.com/problems/find-the-middle-index-in-array/
  public int findMiddleIndex(int[] nums) {
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            total +=nums[i];
        }
        int lsum = 0;
        for(int i=0;i<nums.length;i++){
            if(i != 0 ) lsum += nums[i-1];
            if(total - lsum - nums[i]== lsum){
                return i;
            }
        }
        return -1;
    }
}
