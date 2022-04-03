/*

Time Complexity :  O(n)    O(n) for finding the middle then O(n/2) for reversing the list and O(n)
 for comparing the list.here n  is number of elemenets in the linkedlist.

 Space Complexity : O(1) as we not using any auxillary data structure.

*/

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

class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode first = head;
        ListNode sec = head;
        ListNode newNode = head;

        // finding the middle
        while (first != null && first.next != null) {

            first = first.next.next;
            sec = sec.next;
        }

        // reversed the list from the middle
        ListNode reverse = reverse(sec);

        // comparing elements.
        while (reverse != null && newNode != null) {

            if (newNode.val != reverse.val) {

                return false;
            }
            reverse = reverse.next;
            newNode = newNode.next;
        }

        return true;

    }

    // logic for reversing the list.
    public ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            ListNode sec = head.next;
            head.next = prev;
            prev = head;
            head = sec;
        }

        return prev;
    }
}
