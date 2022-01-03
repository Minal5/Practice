public class Ceiling {

	public static void main(String[] args) {
		int arr[]= {7,12,23,47,68,95,102};
		int target=25;
		int ans=ceiling(arr,target);
		System.out.println(ans);

	}
	//return the index of smallest no. >=target
		static int ceiling(int[] arr,int target)
		{
			//but what if the target is greater than the greatest number in the array
			if(target>arr[arr.length-1])
			{
				return -1;
			}
			int start=0;
			int end=arr.length-1;
			
			while(start<=end)
			{
				int mid=start+ (end-start)/2;
				
				if(target<arr[mid])
					end=mid-1;
				else if(target>arr[mid])
					start=mid+1;
				else
					return mid;
			}
			return start;
		}
}
