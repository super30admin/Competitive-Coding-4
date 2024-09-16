// time complexity: o(n)
// space complexity: o(1)
// idea:
// step1: find the length of linkedlist
// step2: iterate till the mid of the linkedlist, and then reverse the second half of the list
// step3: have two pointers, one at head, and other at the start of the second half of the list.
//        if the values from head to the mid of the list, and from second half start to the end of list are same, then the linked list is a palindrome


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next == null) return true;
        ListNode node1 = head;
        int length = 0;
        while(node1!=null) {
            node1 = node1.next;
            length++;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = null;
        int count = length;

        while(count > length/2 ) {
            p2 = p2.next;
            count--;
            if(count==length/2) {
                ListNode curr = p2;
                while(curr!=null) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                break;
            }
        }
        p2 = prev;
        while(p2!=null) {
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true; 
    }
}