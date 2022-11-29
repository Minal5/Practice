package linkedList;

import java.util.HashSet;

import linkedList.Main.Node;

public class IntersectionOf2LL {

	public static void main(String[] args) {
		
	}
	
	public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node temp1 = head1;
        Node temp2 = head2;
        Node res = new Node(-1);
        Node temp = res;
        while(temp1 != null && temp2 != null){
            if(temp1.data == temp2.data){
                Node node = new Node(temp1.data);
                temp.next = node;
                temp = node;
                temp2 = temp2.next;
                temp1 = temp1.next;
            }else if(temp1.data > temp2.data){
                temp2 = temp2.next;
            }else{
                temp1 = temp1.next;
            }
        }
        return res.next;
    }

}
