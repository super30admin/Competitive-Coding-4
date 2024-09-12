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
// Time Complexity: we are traversing List with 2x and half list wth x speed which makes n/2 time and then again we are traversing both halves of the list at same time which adds to another n/2 making it O(n) time complexity
// Space complexity: No additional data structure is used - O(1)
// Did you complete it on leetcode: yes
// Any problems faced: in final comparison, I was traversing from head till found null which was providing me wrong output. However, I could have checked for reversed list which was sure to have only half of elements.

// Write your approach here:
// Idea here is to check if there are less than 2 numbers, we can return true
// else in case of even numbers we will be getting equal halves and in case of odd numbers
// we will get unequal halves. To compensate that, when fast is not null we increment slow once more to exclude unnecessary element.
// now reversing the later half and comparing the values in both will show us
// if value is nul it is not palidrome else it is.
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null) {
            slow = slow.next;
        }
        ListNode prev = null;
        fast = slow.next;
        while(fast!=null) {
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = slow.next;
        }
        slow.next = prev;
        fast = head;
        while(slow!=null) {
            if(fast.val != slow.val) {
                System.out.println("here1");
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
}