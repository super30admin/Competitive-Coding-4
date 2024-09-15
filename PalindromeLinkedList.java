public class PalindromeLinkedList {


        public boolean isPalindrome(ListNode head) {

            if(head == null) return true;

            // find mid and split into two
            ListNode slow = head;
            ListNode fast = head.next;

            while(fast!= null && fast.next!= null) { // O(n)

                slow = slow.next;
                fast = fast.next.next;
            }

            // head of second half
            ListNode midHead = slow.next;

            // detach
            slow.next = null;

            // reverse second half
            ListNode curr = midHead;
            ListNode left = null;
            ListNode right;

            while(curr!= null) { // O(n)

                right = curr.next;

                curr.next = left;

                left = curr;

                curr = right;
            }

            midHead = left;

            // compare two halves
            while(head != null && midHead != null) { // O(n)

                if(head.val != midHead.val) return false;

                else {

                    head = head.next;
                    midHead = midHead.next;
                }
            }
            return true;


        }
}

/* Time Complexity = O(n)
Space Complexity = O(1) */
