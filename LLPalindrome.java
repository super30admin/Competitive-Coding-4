// Tc = O(n)
// SC = O(1)
// Did this code successfully run on Leetcode :yes 
class LLPalindrome{
    public boolean isPalindrome(ListNode head) {
        //Middle
        //Reverse
        //Compare
        boolean flag = true;
        ListNode slow = ead;
        ListNode fast = head;
        while(fast.next != null || fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode head1 = head;
        ListNode head2 = prev;

        while(head2 != null){
            if(head1.val != head2.val){
                flag = false;
            }
             head1 = head1.next;
            head2 = head2.next;
        }
        return flag;
    }
}