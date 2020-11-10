/**LC-234
 * Time Complexity : O(N) 
 * Space Complexity : O(1) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. Reversed half of the LL and check the other half if it's equal. For n = odd: after reversing increase one pointer, to skip the middle element.
 2. We need to use the three pointer method in order to have the prev pointer which we can later use to traverse in the opposite direction.
 */
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
        
        if(head == null ) return true;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        int len = 0;
        int i = 0;
        int flag = 0;
        while(curr!=null){
            
            len++;
            curr = curr.next;
        }
        
        if(len == 1 ) return true;
        if(len == 2){
            
            if(head.val == head.next.val) return true;
            else return false;
        }
        curr = head;
        
        
         while(i<len/2 && fast.next != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
             i++;
                 
        }
        if(len % 2 != 0){
            curr = curr.next;
        }
        
        System.out.println(prev.val);
        System.out.println(curr.val);
        while(curr != null){
            
            if(prev.val == curr.val){
                curr = curr.next;
                prev = prev.next;
                
            }
            else{
                return false;
            }
        }
            

       return true;
        
    }
}