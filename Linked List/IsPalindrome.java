package linkedList;

public class IsPalindrome {

	public static void main(String[] args) {
		
	}

	public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode l2 = reverse(slow);
        ListNode l1 = head;
        while (l2 != null && l1 != null) {
            if (l2.val != l1.val) return false;
            l2 = l2.next;
            l1 = l1.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
