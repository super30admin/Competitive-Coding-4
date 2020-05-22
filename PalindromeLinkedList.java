package s30Coding;

//Time Complexity :- O(n) traverse all the nodes in the list while calculating the middle element
//Space Complexity :- O(1) No extra space needed
//LeetCode :- Yes
//Logic :- Find mid, reverse second half, compare 2 linked lists.

public class PalindromeLinkedList {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public boolean isPalindrome(ListNode head) {
        if(head == null)  return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next !=null)
       {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head2 = prev;
        while(head !=null && head2!=null){
            if(head.val != head2.val){
                return false;
            }
            
        }
        return true;
    }
}
