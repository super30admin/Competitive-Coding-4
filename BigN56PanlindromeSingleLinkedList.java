// Time complexity is O(N).
// Space complexity is O(1)
// this solution is submitted on leetcode

public class BigN56PanlindromeSingleLinkedList {
	
	    public boolean isPalindrome(ListNode head) {
	        if(head == null || head.next ==null)
	            return true;
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast.next!=null && fast.next.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        fast = reverse(slow.next);
	        System.out.println(fast);
	        slow = head;
	        while(slow!=null && fast!=null){
	            if(slow.val!=fast.val)
	                return false;
	            slow = slow.next;
	            fast= fast.next;
	        }
	        return true;
	    }
	    
	    private ListNode reverse(ListNode node){
	        ListNode prev = null;
	        ListNode curr = node;
	        ListNode fast = node.next;
	        while(fast!=null){
	            curr.next = prev;
	            prev = curr;
	            curr = fast;
	            fast= fast.next;
	        }
	        curr.next = prev;
	        return curr;
	    }
	}