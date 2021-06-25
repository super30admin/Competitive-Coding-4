package CompetitiveCoding4;

public class question58_palindromeLinkedList {

    static ListNode head;
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int d)
        {
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {

        pushElements(1);
        pushElements(2);
        pushElements(3);
//        pushElements(3);
        pushElements(2);
        pushElements(1);
        System.out.println(isPalindrome(head));
    }

    private static void pushElements(int data)
    {
        //Reverse pushing of elements
        ListNode node  = new ListNode(data);
        node.next = head;
        head = node;
    }

    /*
        Time Complexity: O(N)
        Space Complexoty: O(1)
    */
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);

        ListNode firstHalf = head;

        while(firstHalf != null && secondHalf != null) {
            if(firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode node) {
        ListNode temp = node;
        ListNode prev = null;

        while(temp != null) {
            ListNode curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        return prev;
    }
}