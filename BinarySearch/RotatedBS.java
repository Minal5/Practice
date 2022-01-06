package basics;

public class RotatedBS {
	
	public static void main(String[] args)
	{
		int[] arr= {4,5,6,7,0,1,2};
		int target=0;
		int ans=search(arr,target);
		System.out.println(ans);
	}
	
	static int search(int[] nums, int target)
	{
		int pivot=findPivot(nums);
		
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
	static int findPivot(int[] arr)
	{
		int start=0;
		int end=arr.length-1;
		while(start<=end)
		{
			int mid=start +(end-start)/2;
			//4 cases
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
			
			//case 3:
			else if(arr[mid]<=arr[start])
			{
				end=mid-1;
			}
			
			//case 4:
			else
			{
				start=mid+1;
			}
		}
		return -1;
	}
}
