// Time Complexity :o(n) where n is number of nodes
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
//Follow the stps as getListLength , getHeadOfNextHalfAndBreak, reversesecodnhalf, checkPalindrom
class Solution {
    public boolean isPalindrome(ListNode head) {

        int len = getListLength(head);
        ListNode head2 = getHeadOfNextHalfAndBreak(head, len);
        head2 = reverse(head2);
        return checkPalindrom(head, head2);

    }


    public boolean checkPalindrom(ListNode headA, ListNode headB){

        while(headA != null && headB != null){
            if(headA.val != headB.val) return false;
            headA = headA.next;
            headB = headB.next;
        }
        return true;
    }

    public int getListLength(ListNode head){

        int count = 0 ;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode getHeadOfNextHalfAndBreak(ListNode head, int len){

        int half = len/2;

        while(half > 1){
            half--;
            head = head.next;
        }

        ListNode head2 = head.next;
        head.next = null;
        return head2;
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
