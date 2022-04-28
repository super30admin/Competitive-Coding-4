//time - O(n)
//space - O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head, fast = head;
        ListNode mid = null;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow.next);

        slow.next = null;

        slow = head;

        while(slow!=null && reversed!=null){
            if(slow.val!=reversed.val) return false;
            slow = slow.next;
            reversed = reversed.next;
        }

        return true;

    }
    private ListNode reverse(ListNode mid){
        ListNode prev = null, curr = mid, nextPtr = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
            if(nextPtr!=null) nextPtr = nextPtr.next;
        }
        return prev;
    }
}
