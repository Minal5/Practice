package recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { -1,0,3,5,9,12};
		int target = 2;
		System.out.println(search(arr,target)); 
	}

	static int search(int[] nums, int target) {
        return bs(nums, 0, nums.length-1, target);
    
    }
    static int bs(int[] nums, int start, int end , int target){
    	if (start > end) {
        	return -1;
        }
    	
    	int mid = start + (end-start)/2;
           
            if(nums[mid] == target)
                return mid;
            
            else if(nums[mid]<target)
                return bs(nums, mid+1, end,target);
            else 
                return bs(nums, start, mid-1,target);

    }
	
}
