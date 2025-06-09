public class PalindromeLinkedList {

        public boolean isPalindrome(ListNode head) {
            //edge cases check
            if (head == null || head.next == null) {
                return true;
            }

            //initialization of slow and fast pointers
            ListNode slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            //slow will be midpoint
            // we need to reverse list starting after midpoint

            // reverse the linked list

            ListNode second = reverseList(slow);
            ListNode first = head;

            /* two pointer approach for checking items one by one*/

            while (second != null && first != null) {
                if (first.val != second.val) {
                    return false;
                }

                first = first.next;
                second = second.next;
            }

            return true;

        }

        // Iterative reverse linkedList
        private ListNode reverseList(ListNode head) {

            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }

    }