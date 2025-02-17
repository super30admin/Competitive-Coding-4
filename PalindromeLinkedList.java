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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        if(head==null)
        return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        //reversing the second half
        ListNode prev = null;
        ListNode cur = slow.next;
        while(cur!=null)
        {
            ListNode temp = cur.next;
            cur.next= prev;
            prev = cur;
            cur=temp;
        }
        ListNode secondPointer = prev; // for second half
        ListNode firstPointer = head; // for first half
        //checking if its palindrome
        while(secondPointer!=null)
        {
            if(secondPointer.val!=firstPointer.val)
            {
                return false;
            }
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next;

        }
        return true;

    }
}

//tc: O(n)
//sc: O(1)