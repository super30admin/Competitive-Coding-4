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
//Time Complexity: O(n).
//Space Complexity: O(n).
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        Stack<ListNode> s = new Stack<>();
        
        ListNode curr  = head;
        while(curr != null){
            s.push(curr);
            curr = curr.next;
        }
        
        curr = head;
        while(!s.isEmpty() || curr != null){
            if(curr.val != (s.pop()).val)
                return false;
            curr = curr.next;
        }
        
        return true;
    }
}