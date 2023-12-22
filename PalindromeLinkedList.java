//T.C O(n)
//S.C O(1)

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

//Use 2 pointers- slow, fast to traverse to mid of LL. Take mid as new head2 and reverse the 2nd half of LL
//Compare the 1st half and reversed second half LL to check if palindrome.
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //make a new list from half
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;
        //Reverse the 2nd half of LL
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        //Compare both the LL
        while(head!=null && head2!=null){
            if(head.val!=head2.val) return false;
            else{
                head=head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
}