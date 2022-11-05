package stack;

import java.util.Stack;

class MinStack {

    Stack<Long> st = new Stack<Long>();
    Long mini; 

    /** initialize your data structure here. */
    public MinStack() {
        mini = Long.MAX_VALUE; 
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value); 
        if(st.isEmpty()) {
            mini = val; 
            st.push(val); 
        }
        else {
            if(val < mini) {
                st.push(2*val - mini); 
                mini = val; 
            }
            else {
                st.push(val); 
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return; 
        
        Long val = st.pop(); 
        if(val < mini) {
            mini = 2 * mini - val; 
        }
    }
    
    public int top() {
        Long val = st.peek(); 
        if(val < mini) {
            return mini.intValue(); 
        }
        return val.intValue(); 
    }
    
    public int getMin() {
        return mini.intValue(); 
    }
}

// public class MinStackWithAVariable {

// 	public static void main(String[] args) {
		
// 	}
	
// 	Stack<Integer> s = new Stack<>();
// 	int minElement;
// 	public void MinStack() {
        
//     }
    
//     public void push(int val) {
//         if(s.isEmpty()) {
//         	s.push(val);
//         	minElement = val;
//         }
//         if(val >= minElement) 
//         	s.push(val);
//         else if(val < minElement) {
//         	s.push(2*val - minElement);
//         	minElement = val;
//         }
//     }
    
//     public void pop() {
//     	if(s.peek() >= minElement) 
//     		s.pop();
//     	else if(s.peek() < minElement) {
//     		minElement = 2*minElement - s.peek();
//     		s.pop();
//     	}
//     }
    
//     public int top() {
//     	if(s.peek() >= minElement) 
//     		return s.peek();
//     	else  
//     		return minElement;
//     }
    
//     public int getMin() {
//         if(s.size() == 0) 
//         	return -1;
//         return minElement;
//     }

// }

