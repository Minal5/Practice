package linkedList;

import linkedList.Main.Node;
import java.util.*;
public class UnionOf2LL {

	public static void main(String[] args) {
		
	}

	public static Node findUnion(Node head1,Node head2)
	{
	    HashSet<Integer> set = new HashSet<>();
	    Node dummy = new Node(-1);
	    Node result = dummy;
	    while(head1 != null) {
	    	set.add(head1.data);
	    	head1 = head1.next;
	    }
	    while(head2 != null) {
	    	set.add(head2.data);
	    	head2 = head2.next;
	    }
	    for(int val : set) {
	    	Node node = new Node(val);
	    	result.next = node;
	    	result = node;
	    }
	    return dummy.next;
	}
}
