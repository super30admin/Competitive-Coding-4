// Time Complexity : O(n)-> Find the middle + O(n/2) -> Split Reverse of half LL + O(n) -> Traverse again = O(n) where n is number of nodes in LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: Reach the middle of the linked list using the slow and the fast pointer. Once the
middle is reached, reverse the linked list from the middle to end (nodes) and point the fast pointer to the start of the reversed Linked list since
we need to start comparison. Reset head to slow to start the comparisons of equal valued nodes to check palindrome. Traverse head from the start and
fast from the head of the reversed linked list and compare the node values one by one, if anything becomes not equal return false else return true.
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null){ return true;}
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;                                       // Reach the middle of the LL
        }
        fast = reverse(slow.next);                                  // Reverse the second half of the linked list
        slow.next = null;                                           // Split the LL into two halves
        while(head != null && fast != null){
            if(head.val != fast.val){                               // Compare if the values of the nodes are equal in palindrome 
                return false;                                       // Violation!
            }
            head = head.next;
            fast = fast.next;
        }
        return true;                                                // is a palindrome
    }
    
    private ListNode reverse(ListNode head){                        // Standard function to reverse a linked list
        if(head.next == null || head == null){return head;}
        ListNode r = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return r;
    }
}