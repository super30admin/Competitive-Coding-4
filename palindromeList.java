
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Tc --> O(n)
 * Sc --. O(1)
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        //middle 
        if (head.next == null) {
            return true;
        }

        ListNode middle = middleElement(head);

        //reverse from  the middle
        middle.next = reverseList(middle.next);

        //check pallindrome
        boolean flag = true;
        ListNode curr1 = head;
        ListNode curr2 = middle.next;
        while (curr2 != null) {
            if (curr1.val != curr2.val) {
                flag = false;
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }//while
        return flag;

    }

    public ListNode middleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode nextNode = node.next;
        while (nextNode != null) {
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }//while
        curr.next = prev;
        prev = curr;
        return prev;
    }
}
