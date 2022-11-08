package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

	public static void main(String[] args) {
		int N = 5, K = 2;
		int	Arr[] = {12, 5, 787, 1, 23};
		int[] ans = kLargest(Arr,N,K);
		System.out.println(Arrays.toString(ans));

	}

	public static int[] kLargest(int[] arr, int n, int k){
		int[] ans = new int[k];
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			minheap.add(arr[i]);
			if(minheap.size() > k) {
				minheap.poll();
			}
		}
		int i=k-1;
		while(minheap.size() > 0) {
			ans[i--] = minheap.poll();
		}
		return ans;
	}
}
