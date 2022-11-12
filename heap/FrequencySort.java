package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FrequencySort {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2,3};
		int[] ans = frequencySort(nums);
		System.out.println(Arrays.toString(ans));
	}
	
	static class Pair{
        int value;
        int frequency;
        
        public Pair(int v, int f){
            this.value = v;
            this.frequency = f;
        }
    }
    
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.frequency == b.frequency ?b.value - a.value :a.frequency - b.frequency);
        for(HashMap.Entry<Integer, Integer> entry :map.entrySet()){
            Pair temp = new Pair(entry.getKey(),entry.getValue());
            pq.add(temp);
        }
        
        int[] res = new int[nums.length];
        int num = 0, count = 0;
        for(int i = 0; i< nums.length; i++){
            if(count == 0){
                Pair cur = pq.poll();
                num = cur.value;
                count = cur.frequency;
            }
            res[i] = num;
            count--;
        }
        return res;
    }
	
	
	
	
//USING COMPARATOR
	
//	public static int[] frequencySort(int[] nums) {
//		Map<Integer, Integer> heapMap = new HashMap<Integer, Integer>();
//        int[] result = new int[nums.length];
//        for(int index = 0; index < result.length; index++){
//            if(heapMap.get(nums[index]) == null){
//                heapMap.put(nums[index], 1);
//            }else{
//                heapMap.put(nums[index], heapMap.get(nums[index]) + 1);
//            }
//        }
//        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
//                return e1.getValue() == e2.getValue() ? (e1.getKey() < e2.getKey() ? 1 : -1) : (e1.getValue() < e2.getValue() ? -1 : 1);
//            }
//        };
//        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(comparator);
//        minHeap.addAll(heapMap.entrySet());
//        int index = 0;
//        while(!minHeap.isEmpty()){
//            int key = minHeap.poll().getKey();
//            int val = heapMap.get(key);
//            int range = index+val;
//            for(int i = index; i < range; i++){
//                result[i] = key;
//                index++;
//            }
//        }
//        return result;
//    }

}


//METHOD 2: USING COMPARATORS
//class CustomCom implements Comparator<Map.Entry<Integer, Integer>>{
//
//    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
//
//        if(m1.getValue() == m2.getValue())
//            return m2.getKey() - m1.getKey();
//        else
//            return m1.getValue() - m2.getValue();
//    }
//}
//class Solution {
//    public int[] frequencySort(int[] arr) {
//       HashMap <Integer,Integer> map=new HashMap<>();
//        for (int i = 0; i < arr.length ; i++) {
//            map.put(arr[i],map.getOrDefault(arr[i],0)+1 );
//        }
//
//        PriorityQueue <Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>(
//                new CustomCom()
//        );
//        maxHeap.addAll(map.entrySet());
//        ArrayList <Integer> lst=new ArrayList<>();
//        while (!maxHeap.isEmpty())
//        {
//         Map.Entry<Integer,Integer> entry=maxHeap.poll();
//
//            for (int i = 0; i <entry.getValue() ; i++) {
//                lst.add(entry.getKey());
//            }
//
//
//        }
//        int arr2[]=new int[arr.length]; 
//        for (int i = 0; i < arr.length ; i++) {
//            arr2[i]=lst.get(i);
//        }
//return arr2;
//       
//    }
//}
