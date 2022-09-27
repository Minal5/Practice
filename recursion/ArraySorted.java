package recursion;

import java.util.*;

public class ArraySorted {

	public static void main(String[] args) {
//		int[] arr= {1,2,4,8,6,9,5};
//		System.out.println(sorted(arr,0));
		ArrayList<Integer> a=new ArrayList<>();
		a.add(2);
		a.add(6);
		a.add(9);
		a.add(4);
		a.add(3);
		System.out.println(a);
		sort(a);
		System.out.println(a);
	}

	static void sort(ArrayList<Integer> a) {
		if(a.size() == 1) {
			return;
		}
		int temp = a.get(a.size()-1);
		a.remove(a.get(a.size()-1));
		sort(a);
		insert(a,temp);
	}
	
	static void insert(ArrayList<Integer> a, int temp) {
		if(a.size() == 0 ||a.get(a.size()-1)<=temp) {
			a.add(temp);
			return;
		}
		int val=a.get(a.size()-1);
		a.remove(a.get(a.size()-1));
		insert(a,temp);
		a.add(val);
		return;		
	}
  
	static boolean sorted(int[] arr,int index) {
		if(index == arr.length-1) {
			return true;
		}
		
		return arr[index] < arr[index+1] && sorted(arr,index + 1);
	}
}
