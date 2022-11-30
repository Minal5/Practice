package linkedList;
//gfg
//https://practice.geeksforgeeks.org/problems/reorder-list/1

import linkedList.Main.Node;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node reorderlist(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //split the list into 2 lists
        Node l1 = head;
        Node l2 = reverse(slow.next);
        slow.next = null;
        
        //merge the two lists
    	Node ans = new Node(0) ;
        Node cur= ans  ;
        while(l1 !=null || l2!=null){
            if(l1 != null){
                cur.next = l1 ;
                cur = cur.next ;
                l1  = l1.next ;
            }
            if(l2 != null){
                cur.next = l2 ;
                cur = cur.next ;
                l2  = l2.next ;
            }
        }
        return ans.next ;

    }
    
    public Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        while(cur != null) {
        	Node temp = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = temp;
        }
        return prev;
    }

}
