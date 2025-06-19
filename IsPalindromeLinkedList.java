// Time Complexity: O(n) where n is the number of elements in the input linked list
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes

public class IsPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode midElement = findMidElement(head);
        ListNode reversedHead = reverseLinkedList(midElement);

        ListNode start = head;
        while (reversedHead != null) {
            if (reversedHead.val != start.val) {
                return false;
            }
            reversedHead = reversedHead.next;
            start = start.next;
        }

        return true;
    }

    private ListNode findMidElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode newHead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newHead;
        }

        return prev;
    }
}

class IsPalindromeLinkedListRunner {
    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,2,1};
        ListNode inputHead = createLinkedList(input);
        IsPalindromeLinkedList isPalindromeLinkedList = new IsPalindromeLinkedList();

        boolean isPalindrome = isPalindromeLinkedList.isPalindrome(inputHead);
        System.out.println(isPalindrome);
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}