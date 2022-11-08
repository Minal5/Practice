package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void main(String[] args) {
		int arr[] = {7,10,4,3,20,15};
		int K = 3;
		System.out.println(kthSmallest(arr,0,arr.length-1,K));
	}

	public static int kthSmallest(int[] arr, int l, int r, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++) {
        	maxHeap.add(arr[i]);
        	if(maxHeap.size() > k) {
        		maxHeap.poll();
        	}
        }
        return maxHeap.peek();
		
	}
}
