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
//Time Complexity=O(n)
//Space Complexity=O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer>stack=new Stack();
        ListNode cur=head;
        while(cur!=null)
        {
            stack.push(cur.val);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null && !stack.isEmpty())
        {
            if(stack.pop()!=cur.val)
            {
                return false;
            }
            cur=cur.next;
        }
        return true;
    }
}