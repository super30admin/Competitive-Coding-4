
// Time Complexity : O(n)
// Space Complexity : O(1) excluding recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : faced difficulties in coding recursion
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode start;
    public boolean isPalindrome(ListNode head) {
        start=head;
        return isPalindrome1(head);
    }
    public boolean isPalindrome1(ListNode end){
        if(end==null){
            return true;
        }
        
        boolean flag=isPalindrome1(end.next);
        flag=flag && start.val==end.val;
        start=start.next;
        return flag;
        
    }
}