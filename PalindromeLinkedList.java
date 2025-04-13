// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Traverse the linked list and store all node values in an ArrayList.
//    - Use two pointers (start and end) to compare the values from both ends.
//    - If all mirrored values match, return true (it’s a palindrome).

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //basic - put all numbers in array and then use 2 pointers
        List<Integer> values = new ArrayList<>();
        //convert linkedlist to ArrayList
        ListNode temp = head;
        while(temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int front = 0;
        int back = values.size() - 1;
        while(front < back) {
            if(values.get(front) != values.get(back)) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2));

        PalindromeLinkedList checker = new PalindromeLinkedList();

        System.out.print("List 1: ");
        printList(head1);
        System.out.println("Is palindrome? " + checker.isPalindrome(head1));
    }
}
