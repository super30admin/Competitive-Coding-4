// Time Complexity :  O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



// Your code here along with comments explaining your approach
import java.util.*;

  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> ll = new ArrayList<>();
        while (head != null){
            ll.add(head.val);
            head = head.next;
        }

        int start = 0;
        int end = ll.size()-1;

        while (start < end){
            if (ll.get(start) != ll.get(end)){
                return false;
            }
            start ++;
            end--;
        }
        return true;
    }
}
