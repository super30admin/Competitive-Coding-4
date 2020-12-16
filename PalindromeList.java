// Time Complexity :O(N)
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Find the size of the list and then midpoint.Travers the pointer to the midpoint
//and then reverse the linked list from midpoint. Now traverse from the start and midpoint simultaneously and check the nodes if they are equal.
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
        if(head == null || head.next == null)
            return true;
        ListNode start = head;
        int size=0;
        while(start!=null){
            start=start.next;
            size++;
        }
        size--;
   //     System.out.println(size);
        int mid= size/2;
        start=head;
        ListNode midpt = head;
        while(mid!=0){
            midpt=midpt.next;
            mid--;
        }
        midpt=midpt.next;
   //     System.out.println(midpt.val);
        ListNode previous =null;
        while(midpt!=null){
            ListNode current = midpt.next;
            midpt.next=previous;
            previous=midpt;
            midpt=current;
        }
        while(previous!=null){
            if(start.val==previous.val){
                start=start.next;
                previous=previous.next;
            }
            else
                return false;
        }
        return true;        
    }
}