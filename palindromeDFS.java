//TC:O(n)
//SC:o(1)
//Palindrome means it starts from left and right using 2 pointers if both the values are same then it moves to next element this is palindrome if not same then it is not a palindrome LL.ex:12321-->123null,21null,reverse 12null.If equals both the left and right values then move forward and same do the rest of the process and stop at 3 becoz it is middle most element.
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