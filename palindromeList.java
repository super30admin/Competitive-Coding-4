// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Main {
    public static boolean isPalindrome(ListNode head) {

        // null case and one size list
        if (head.next == null && head == null)
            return true;

        // slow pointer and fast pointer
        ListNode slow = head;
        ListNode fast = head;
        // fast pointer will move two steps whil slow pointer will move one step for
        // getting mid element
        // here I am checking fast.next and fast.next.next as there may be odd number of
        // element or even number of element
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // second half
        ListNode sH = slow.next;
        // break the second half;
        slow.next = null;
        // reverse the second half
        ListNode rev = reverse(sH);
        // check palindrome
        // here I am checking second half is null or not as for odd number of list there
        // is one more element in first half
        while (rev != null) {
            // checking palindrome or not
            // first half 1->2->3
            // second half 1->2
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }

        return true;

    }

    private static ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode dummy = head;
            head = head.next;
            dummy.next = result;
            result = dummy;
        }
        return result;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }
}