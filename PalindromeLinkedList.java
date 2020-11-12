// Time Complexity : O(n) where  n is no.of nodes in the LinkedList
// Space Complexity : O(1) no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * Approach is to find the middle of the linkedlist, reverse the second half of the linked list.
 * Compare the two linked list to check if it is  palindrome, and reverse back the original linked list
 * to it original state
 * */

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode middle = findMiddle(head);

        ListNode secondBegin = reverse(middle.next);

        ListNode p1 = head;
        ListNode p2 = secondBegin;
        boolean result = true;
        while (p2!=null){
            if(p1.val!=p2.val){
                result  = false;
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }

        //make the revered list back to origin state
        middle.next = reverse(secondBegin);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode fwd = head.next;
        while (fwd!=null){
            cur.next = prev;
            prev = cur;
            cur = fwd;
            fwd=fwd.next;
        }
        cur.next=prev;
        return cur;
    }

    private ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}