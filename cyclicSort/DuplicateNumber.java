package cyclicSort;

public class DuplicateNumber {

	public static void main(String[] args) {
		int[] arr = {1,3,4,2,2};
		System.out.println(findDuplicate(arr));
	}
	
	public static int findDuplicate(int[] nums) {
		int i=0;
		while(i<nums.length) {
			int correct = nums[i] - 1;
			if(nums[i] != nums[correct]) {
				swap(nums,i,correct);
			}else {
				i++;
			}
		}
		
		for(int index=0;index<nums.length;index++) {
			if(nums[index] != index+1) {
				return nums[index];
			}
		}
		return nums.length;
	}
	
	public static void swap(int[] nums,int f, int s) {
		int temp = nums[f];
		nums[f] = nums[s];
		nums[s] = temp;
	}

}
