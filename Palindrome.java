/**
 * Checks if a singly linked list is a palindrome.
 * Uses fast/slow pointers to split the list, reverses the second half, 
 * and compares both halves for equality .

// Time Complexity : O(n)
// Space Complexity: O(1)

*/

class Solution {
    public boolean isPalindrome(ListNode head) {

       ListNode fsthalf = endOfFirst(head);
       ListNode scdhalf = reverseList(fsthalf.next);

        ListNode p1 = head;
        ListNode p2 = scdhalf;

        boolean flag = true;

        while(flag && p2!=null){
            if(p1.val!=p2.val) {
                flag = false;
                return flag;
            } 
            p1 = p1.next;
            p2 = p2.next;
        }
        return flag;
    }

    public ListNode endOfFirst(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }
}
