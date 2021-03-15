// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Got mixed up in the mock interview as interviewer tried to implement their approach which went on to
//failed cases.


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public boolean isPalindrome(ListNode head) {
      if(head == null)
      {
        return false;
      }
      //find the last element of the first half which will also be the mid point
      ListNode lastFirstHalf = findLastFirstHalf(head);
      //reverse the second half of the linked list
      ListNode firstSecondHalf = reverseList(lastFirstHalf.next);
      //two pointer to go over each element of first half and second half
      ListNode p1 = head;
      ListNode p2 = firstSecondHalf;
      //check only if p2 is null as if their are odd number of elements then we dont need to check for that one extra element
      //from first half of the list
      while(p2!= null)
      {
        if(p1.val != p2.val)
        {
          return false;
        }
        p1 = p1.next;
        p2 = p2.next;
      }

      return true; 
    }
   //method to reverse a linkedlist
  private ListNode reverseList(ListNode head)
	{
		
		ListNode prev = null;
		ListNode current = head;
		
		while(current!=null)
		{
			ListNode nextTemp = current.next;
			current.next = prev;
			prev = current;
			current = nextTemp;
		}
		
		return prev;
		
	}
//method to find the point where we want to divide the list
  private ListNode findLastFirstHalf(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next!= null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}