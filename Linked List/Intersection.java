package linkedList;
//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class Intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Method 1
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different length ,then we will stop the loop after second iteration
        while(a != b) {
        	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        	a = a == null ? headB : a.next;
        	b = b == null ? headA : b.next; 
        }
        return a;
    }
	
	//Method 2
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
            
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;
        
        // count length for each list
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }
        
        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }
        
        // skip longer list by diff nodes
        int diff = Math.abs(lenA - lenB);
        p1 = lenA > lenB ? headA : headB;
        
        while (diff-- > 0)
            p1 = p1.next;
            
        p2 = lenA > lenB ? headB : headA;
        
        // compare two lists with equal length
        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return p1;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return null;
    }
	
}
