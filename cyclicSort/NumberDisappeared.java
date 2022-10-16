package cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class NumberDisappeared {

	public static void main(String[] args) {
		int[] arr = {1,1};
		System.out.println(findDisappearedNumbers(arr));
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums){
		List<Integer> ans = new ArrayList<>();
		int i=0;
		while(i<nums.length) {
			int correct = nums[i] - 1;
			if(nums[i] != nums[correct]) {
				swap(nums, i, correct);
			}else {
				i++;
			}
		}
		
		for(int index=0;index<nums.length;index++) {
			if(nums[index] != index+1) {
				ans.add(index+1);
			}
		}
		return ans;
	}
	
	public static void swap(int[] nums,int f,int s) {
		int temp = nums[f];
		nums[f] = nums[s];
		nums[s] = temp;
	}
}
