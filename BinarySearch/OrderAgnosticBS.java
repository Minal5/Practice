public class AgnosticBS {

	public static void main(String[] args) {
		int arr[]= {12,24,45,67,78,89,90};
		int target=67;
		int ans=orderAgnosticBS(arr,target);
		System.out.println(ans);
		

	}
	static int orderAgnosticBS(int []arr,int target)
	{
		int start=0;
		int end=arr.length-1;
		
    //Ascending 
		while(start<end)
		{
			int mid=start +( end-start)/2;
			if(arr[mid]==target)
				return mid;
			if(target<arr[mid])
			{
				end=mid-1;
			}
			else if(target>arr[mid])
			{
				start=mid+1;
			}
			else 
				return mid;
		}
    
    //Descending
		while(start>end)
		{
			int mid=start +( end-start)/2;
			if(arr[mid]==target)
				return mid;
			if(target<arr[mid])
			{
				start=mid+1;
			}
			else if(target>arr[mid])
			{
				end=mid-1;
			}
			else 
				return mid;
		}
		return -1;
		
		
	}

}
