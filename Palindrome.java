/** TC O(N) SC O(N) - for the recursion
* Code submitted on leetcode
* Reach the midpoint of the list and reverse the second half of list 
* Perform a 2 pointer comparision to see if the elements are matching
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
         if (head == null)
            return true;
      
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        if (fast != null && fast.next != null) {
            fast = helper(fast, fast, fast.next);    
        }
        while (fast != null) {
            if (slow.val != fast.val) {
                isPalindrome = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return isPalindrome;
    }
    
    ListNode helper(ListNode head, ListNode prev, ListNode temp) {
        if (prev == null || prev.next == null) {
            return head;
        }
            prev.next = temp.next;
            temp.next = head;
            head = temp;
            return helper(head, prev, prev.next);  
    }
}
