// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach-My approach was to find the middle of the list and then reversing the second half and
// the compare the first and the second half to see if they are identical or not
public class PlaindromeLinkedList {
    static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class LinkedList1 {

        static boolean isPalindrome(ListNode1 head) {
            if(head.next == null) return true;
            ListNode1 slow = head;
            ListNode1 fast = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null) {
                fast = reverse(slow.next);
            } else {
                fast = reverse(slow);
            }
            slow = head;
            while(fast != null) {
                if(slow.val != fast.val) return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
        static ListNode1 reverse(ListNode1 head) {
            if (head == null || head.next == null) return head;
            ListNode1 newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        static void printList(ListNode1 head) {
            ListNode1 current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(1);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(3);
        ListNode1 node4 = new ListNode1(2);
        ListNode1 node5 = new ListNode1(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedList1.printList(node1);
        System.out.println("Is list palindromic: " + LinkedList1.isPalindrome(node1));
    }
}
