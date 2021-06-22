package CompetitiveCoding4;

	//basecase
	//find middle by slow 1 and fast 2
	//reverse the list from 2nd half
	//check each elem in two lsists
	class isPalindrome {
		public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
		
	    public boolean isPalindrome(ListNode head) {
	        if(head.next == null) return true;
	        
	        ListNode slow = head;
	        ListNode fast = head.next.next;
	        
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        ListNode reverseHead = null;
	        
	        if(fast == null){
	            reverseHead = reverse(slow.next);
	        }else{
	            reverseHead = reverse(slow.next.next);
	        }
	        
	        while(head!= null && reverseHead!= null){
	            if(head.val != reverseHead.val) return false;
	            head = head.next;
	            reverseHead = reverseHead.next;
	        }
	        return true;
	    }
	    
	    private ListNode reverse(ListNode head){
	        ListNode prev = null;
	        ListNode cur = head;
	        while(cur != null){
	            ListNode next = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = next;
	        }
	        return prev;
	    }
	}
