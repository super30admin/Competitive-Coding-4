/*
 * Time Complexity : O(n)
 * Space Complexity :  O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - For this question, our approach is to reverse the end half of the linked list and check if the first half and seconf half are equal. We consider 2 pointers and slow and fast 
 * and increment fast by 2 and slow by until fast == null. Then we reverse the half from slow +1 till the end. We then traverse through the elements of the reverse linkedList and our linked
 * list 1 by 1 and check if they are same. If they are then the list is a palindrome or else we return false.
 */

//https://leetcode.com/problems/palindrome-linked-list/

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
class LLisPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = reverse(slow.next);
        slow=head;
        while(fast!=null){
            if(fast.val!=slow.val)return false;
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur=head;
        while(head!=null){
            head=head.next;
            cur.next=prev;
            prev = cur;
            cur=head;
        }
        return prev;
    }
}