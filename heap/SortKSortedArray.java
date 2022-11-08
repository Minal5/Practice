package stack;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SortKSortedArray {

	public static void main(String[] args) {
		int n = 7, k = 3;
		int arr[] = {6,5,3,2,8,10,9};
		System.out.println(nearlySorted(arr,n,k));
	}

	public static ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			minheap.add(arr[i]);
			if(minheap.size() > k) {
				ans.add(minheap.poll());
			}
		}
		while(minheap.size() > 0) {
			ans.add(minheap.poll());
		}
		
		return ans;
    }
}
