// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {

  public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    //split the list - slow will be in the middle and fast will point to the tail
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    //1-2-3-2-1-null
    if (fast != null) {
      slow = slow.next;
    }
    //reverse the second half of the list and point fast to head. Currently, fast is at the tail
    slow = reverse(slow);
    fast = head;

    //check if the elements are same or not
    while (slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      //if the elemenst are same, we move the pointers ahead
      slow = slow.next;
      fast = fast.next;
    }
    return true;
  }

  public ListNode reverse(ListNode head) {
    //Reverse Logic
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
