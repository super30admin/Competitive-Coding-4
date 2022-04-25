class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PallindromeList {

    // TC: O(n) n - number of nodes in a linked list
    // SC: O(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        // 1. Find out the middle node
        ListNode middleNode = getMiddleNode(head);

        // 2. reverse whatever is there after the middle node
        ListNode secondHead = reverseList(middleNode.next);
        middleNode.next = null;

        ListNode firstHead = head;

        // 3. compare the nodes one by one
        while(secondHead != null) {
            // If two pointers match
            if(firstHead.val == secondHead.val) {
                firstHead = firstHead.next;
                secondHead = secondHead.next;
            }else {
                return false;
            }

        }
        return true;
    }

    private ListNode getMiddleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;


        while(next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        return current;
    }
}
