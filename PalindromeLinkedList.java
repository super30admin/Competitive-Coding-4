// TC: O(N)
// SC: O(1), where N is the number of nodes in the linked list
// Did it run successfully on Leetcode? : Yes

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseLinkedList(slow);

        while(secondHalf!=null){
            if(head.val!=secondHalf.val){
                return false;
            }
            secondHalf = secondHalf.next;
            head = head.next;
        }

        return true;

    }

    private ListNode reverseLinkedList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = curr.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}