package linkedList;

public class OddEvenLL {

	public static void main(String[] args) {
		
	}
	
	public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode even = head.next;
        ListNode evenhead = even;
        ListNode odd = head;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

}
