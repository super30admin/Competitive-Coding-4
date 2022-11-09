package s30.linkedList;

// Algo
// breaking the list into two halves with MID.
// Reversing the second half of the list.
// Checking if they are equal.

//Time Complexity: O(n)
// Space Complexity: O(1)

public class PalindromeList {

    public boolean isPalindrome(ListNode head) {

        ListNode mid = getMid(head);

        ListNode reverseHead = getReverseHead(mid);

        while(head != null){
            if(head.val != reverseHead.val) return false;
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode getReverseHead(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {

    }
}
