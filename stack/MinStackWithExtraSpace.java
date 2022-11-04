package stack;

import java.util.Stack;

public class MinStackWithExtraSpace {

	public static void main(String[] args) {
		
	}

	Stack<Integer> s = new Stack<>();
	Stack<Integer> ss = new Stack<>();
	public void MinStack() {

    }
    
    public void push(int val) {
    	s.push(val);
        if(ss.size() == 0 || ss.peek() >= val)
        	ss.push(val);
        return;
    }
    
    public void pop() {
        if(s.size()==0)
        	return ;
        int ans = s.peek();
        s.pop();
        if(ss.peek() == ans)
        	ss.pop();
        return;
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        if(s.size() == 0)
        	return -1;
        return ss.peek();
    }
	
}
