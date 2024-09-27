// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        ListNode fast = head, slow = head;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(fast != null){
            arr.add(fast.val);
            fast = fast.next;
        }
        
        slow = reverse(slow);
        int c = 0;
        
        while (slow != null &&  c < arr.size()) {
            if ( slow.val != arr.get(c)) {
                return false;
            }
            c = c + 1;
            slow = slow.next;
            
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
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