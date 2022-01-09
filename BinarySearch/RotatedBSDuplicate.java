package basics;

public class RotatedBSDuplicate {

	public static void main(String[] args) {
		int[] arr= {2,5,6,0,0,1,2};
		int target=3;
		int ans=search(arr,target);
		System.out.println(ans);

	}


	static int search(int[] nums, int target)
	{
		int pivot=findPivotWithDuplicates(nums);
		
		//If we did not find a pivot, it means the array is not rotated.
		if(pivot==-1)
		{
			//Just do normal binary search
			 return binarySearch(nums,target,0,nums.length-1);
		}
		
		//if pivot is found,we have 2 asc sorted arrays
		if(pivot==target)
			return pivot;
		else if(target>=nums[0])
		{
			return binarySearch(nums,target,0,pivot-1);
		}
		else
			return binarySearch(nums,target,pivot+1,nums.length-1);
	}
	
	static int binarySearch(int[] arr,int target,int start,int end)
	{
		while(start<=end)
		{
			int mid=start+(end-start)/2;

			if(target<arr[mid])
			{
				end=mid-1;

			}
			else if(target>arr[mid])
			{
				start=mid+1;
			}
			else if(target==arr[mid])
				return mid;
		}
		return -1;
		
	}
	
	static int findPivotWithDuplicates(int[] arr)
	{
		int start=0;
		int end=arr.length-1;
		while(start<=end)
		{
			int mid=start +(end-start)/2;
			//case 1:
			if(mid<end && arr[mid]>arr[mid+1])
			{
				return mid;
			}
			
			//case 2:
			if(mid>start && arr[mid]<arr[mid-1])
			{
				return mid-1;
			}
			
			//if elements at middle,start,end are equal then just skip the duplicates
			if(arr[mid]==arr[start] && arr[mid]==arr[end])
			{
				//skip the duplicates
				//NOTE: what if these elements at start and end were the pivot??
				//check if start is pivot
				if(arr[start]>arr[start+1])
					return start;
				start++;
				//check whether end is pivot
				if(arr[end]<arr[end-1])
					return end-1;
				end--;
			}
			//left side is sorted, so pivot should be in right
			else if(arr[start]<arr[mid]||(arr[start]==arr[mid] && arr[mid]>arr[end]))
			{
				start = mid+1;
			}
			else
			{
				end=mid-1;
			}
			
			
			
		}
		return -1;
	}

}
