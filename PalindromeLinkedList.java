//Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//take slow and fast pointer and itearte through the array.
//reverse the second array
//compare slow and fast 

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        // Default constructor
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class PalindromeLinkedList {
    ListNode result;

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move slow to the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        fast = reverse(slow);
        slow = head;

        // Compare the first half with the reversed second half
        while (slow != null && fast != null) {
            if (slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                return false;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        result = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return result;
    }

    public static void main(String[] args) {
        // Creating a sample linked list
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        // Creating an instance of Solution
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // Checking if the linked list is a palindrome
        boolean isPalindrome = solution.isPalindrome(head);

        // Printing the result
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
