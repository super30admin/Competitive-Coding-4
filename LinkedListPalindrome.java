// Time complexity: O(n)
// space complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        ListNode curr = head;
        ListNode curr2 = head2;
        while(curr != null && curr2 != null) {
            if(curr.val != curr2.val) {
                return false;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }
        return true;

    }


    private ListNode reverse(ListNode node) {

        ListNode prev = null;
        ListNode curr = node;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;    
        }

        return prev;
    }
}