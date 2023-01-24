// Approach: Reverse the 2nd half in place and then use 2 pointers to check if both lists
// have same val nodes, if not return false else return true
// Time: O(n)
// Space: O(1)
class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        if (head.next == null || head == null) return true;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2nd list starts at slow.next ptr, reverse it

        ListNode currNode = slow.next;
        ListNode newList = reverse(currNode);
        int i = 0;

        while (newList != null) {
            if (newList.val != head.val) return false;
            head = head.next;
            newList = newList.next;
            i++;
        }
        return true;
    }

    ListNode reverse(ListNode root) {
        ListNode prev = null, curr = root, fast = curr.next;
        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}