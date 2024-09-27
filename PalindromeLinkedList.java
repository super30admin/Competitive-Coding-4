// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Find the mid of list
//Reverse the list from the mid to end
//Check if the first half and reverse half are matching
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
        if(head == null){
            return true;
        }
        ListNode mid1 = findmid(head);
        ListNode secrev1 = findrev(mid1.next);
        
        ListNode mid = head;
        ListNode secrev = secrev1;
        boolean result = true;
        while(result && secrev != null){
            if(secrev.val != mid.val)
                result = false;
            secrev = secrev.next;
            mid = mid.next;
        }
        mid1.next = findrev(secrev1);
        return result;
    }
    public ListNode findrev(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
       while(curr != null){
           ListNode nextT = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextT;
       }
        return prev;
    }
    public ListNode findmid(ListNode head){
        ListNode first = head;
        ListNode sec = head;
        //if(head == null)
        while(sec.next != null && sec.next.next != null){
            first = first.next;
            sec = sec.next.next;
        }
        return first;
    }
}