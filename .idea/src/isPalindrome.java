class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        //traverse slow and fast
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half
        ListNode newHead = slow;
        ListNode prev = null;
        while (newHead != null) {
            ListNode A = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = A;
        }
        ListNode s = head;
        ListNode e = prev;
        while(s!=null && e!=null) {
            if(s.val != e.val) {
                return false;
            }
            s = s.next;
            e = e.next;
        }
        return true;
    }
}