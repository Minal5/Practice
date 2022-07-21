package linkedList;

public class DoublyLL {
	
    Node head;
//	Node tail;
	
	private int size;
	
	public DoublyLL() {
		this.size = 0;
	}
	
	private class Node{
		int val;
		Node next;
		Node prev;
		
		public Node(int val) {
			this.val = val;
			
		}
		
		public Node(int val,Node next,Node prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public void insertFirst(int val) {
		Node node=new Node(val);
		node.next = head;
		node.prev = null;
		if(head != null) {
			head.prev = node;
		}
		head = node; 
	}
	
	public void display() {
		Node node = head;
		Node last = null;
		while(node != null) {
			System.out.print(node.val +" -> ");
			last = node;
			node=node.next;
		}
		System.out.println("END");
		
		System.out.println("Print in reverse");
		while(last != null) {
			System.out.print(last.val +" -> ");
			last = last.prev;
		}
		System.out.println("START");
	}
	
	public void insertLast(int val) {
		Node node = new Node(val);
		Node last = head;
		
		node.next = null;
		
		if(head == null) {
			node.prev = null;
			head = node;
			return;
		}
		
		while(last.next != null)
		{
			last=last.next;
		}
		
		last.next=node;
		node.prev=last;
	}
	
	public Node find(int val) {
		Node node = head;
		while(node != null) {
			if(node.val == val) {
				return node;
			}
			node = node.next;
		}
		
		return null;
	}
	
	public void insert(int after, int val) {
		Node p = find(after); 
		
		if(p == null) {
			System.out.println("does not exist");
		}
		
		Node node = new Node(val);
		node.next = p.next;
		p.next = node;
		node.prev = p;
		if(node.next != null) {
			node.next.prev = node;
		}
	}
	

	public static void main(String[] args) {
		DoublyLL list=new DoublyLL();
		list.insertFirst(2);
		list.insertFirst(7);
		list.insertFirst(5);
		list.insertLast(99);
		list.insert(7, 65);
		list.display();

	}

}
