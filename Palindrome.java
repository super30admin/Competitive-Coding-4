public class Palindrome {

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode first = head;
        ListNode mid = findMid(head);
        ListNode second = reverse(mid.next);

        while(second != null){
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    private static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
