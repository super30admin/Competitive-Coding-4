// Time Complexity : O(n)
// Space Complexity : O(1)

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr.next!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow);
        slow.next = null;
        slow = head;
        while(fast!=null){
            if(slow.val!=fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}