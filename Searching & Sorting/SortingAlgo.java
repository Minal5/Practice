import java.util.Arrays;

public class SortingAlgo {
	
	static void bubbleSort(int[] arr)
	{	int temp=0;
		for(int i=0;i<arr.length;i++){	
			for(int j=1;j<arr.length-i;j++){
				if(arr[j]<arr[j-1]){
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}	
	}
	static void selectionSort(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{	//find the max item in the remaining array and swap it with correct index
			int last=arr.length-i-1;
			int maxIndex=getMaxIndex(arr,0,last);
			swap(arr,maxIndex,last);
		}
	}
	 
	private static int getMaxIndex(int[] arr,int start,int end)
	{
		int max=start;
		for(int i=start;i<=end;i++)
		{
			if(arr[max]< arr[i])
			{
				max = i;
			}
		}
		return max;
	}
	
	static void insertionSort(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j>0;j--)
			{
				if(arr[j]<arr[j-1])
				{
					swap(arr,j,j-1);
				}
				else
				{
					break;
				}
			}
		}
	}
	
	static void swap(int[] arr,int first,int second)
	{
		int temp=arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}

	public static void main(String[] args) {
		int[] arr= {2,5,0,-7,3};
//		bubbleSort(arr);
//		System.out.println(Arrays.toString(arr));
//		selectionSort(arr);
//		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		

	}

}
