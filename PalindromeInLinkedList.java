// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


public class PalindromeInLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;

        while(head != null && head2 != null){
            if(head.val != head2.val) {
                return false;
            }else{
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    private static ListNode[] valuesToListNodes(int[] values) {
        final ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; ++i) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) {
                nodes [i - 1].next = nodes[i];
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        ListNode[] nodes = valuesToListNodes(new int[] {1, 2, 3, 4});
        System.out.println("Is the linked list a palindrome: " + new PalindromeInLinkedList().isPalindrome(nodes[0]));
        nodes = valuesToListNodes(new int[] {1, 2, 3, 4});
    }


}
