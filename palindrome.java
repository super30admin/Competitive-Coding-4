// TC: O(n)
// SC: O(1)

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
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left=head; 
        return isPalindromeHelper(head);
    }
    public boolean isPalindromeHelper(ListNode right){ 
        if(right==null) return true;
        //logic
        boolean result=isPalindromeHelper(right.next);
        if(result == false)return false;
        else if(left.val!=right.val)return false;
        else{
            left=left.next;
            return true;
        }
    }

} 