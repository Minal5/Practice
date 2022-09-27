package recursion;

import java.util.*;

public class StackSort {

	public static void main(String[] args) {
		Stack<Integer> s=new Stack<>();
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(7);
		s.push(0);
		System.out.println(s);
		sort(s);
		System.out.println(s);
	}

	static void sort(Stack<Integer> s) {
		if(s.size()==1) {
			return;
		}
		int temp = s.get(s.size()-1);
		s.pop();
		sort(s);
		insert(s,temp);
	}
	static void insert(Stack<Integer> s,int temp) {
		if(s.size()==0 || s.get(s.size()-1)<=temp) {
			s.push(temp);
			return;
		}
		int val = s.get(s.size()-1);
		s.pop();
		insert(s,temp);
		s.push(val);
		return;
	}
}
