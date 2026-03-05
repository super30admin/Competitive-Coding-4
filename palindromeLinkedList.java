// TimeComplexity: O(n)
// SpaceComplexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast= fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode temp = curr;
        while(temp !=null) {
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        slow.next = null;
        // reusing the pointers instead of adding new ones
        slow = head;
        fast = prev;
        while(slow!=null && fast!=null) {
            if(slow.val!=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;    
    }
}
