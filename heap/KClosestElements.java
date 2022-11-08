package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
	public static class Pair implements Comparable<Pair>{
        int val,dist;
        Pair(int val,int dist){
            this.val=val;
            this.dist=dist;
        }
        public int compareTo(Pair o){
            if(this.dist==o.dist){
                return this.val-o.val;
            }else{
                return this.dist-o.dist;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
            }else{
                if(pq.peek().dist>Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.remove().val);
        }
        Collections.sort(list);
        return list;
    }
}
