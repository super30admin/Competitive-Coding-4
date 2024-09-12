// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
		ListNode fast=head;
		ListNode mid=null;
	
		//for finding mid node
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		// odd if fast is not null
		if(fast!=null)
		{
			mid=slow.next;
		}
		else
		{
			mid=slow;
		}
		
		ListNode prev=null;
		ListNode next=null;
		//reversing last half
		while(mid!=null)
		{
			next=mid.next;
			mid.next=prev;
			prev=mid;
			mid=next;
		}
		
		//comparing first and last half 
		while(prev!=null)
		{
			if(prev.val!=head.val)
				return false;
				
		     prev=prev.next;
		     head=head.next;
		}
		return true;
    }
}
