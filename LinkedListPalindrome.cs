public class LinkedListPalindrome
    {
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        // Approach: Use 2 pointers to split the linked list in half
        //           reverse the second half
        //           compare both first half and second half

        public class ListNode
        {
            public int val;
            public ListNode next;
            public ListNode(int x)
            {
                val = x;
                next = null;
            }
        }

        public bool IsPalindrome(ListNode head)
        {
            if (head == null || head.next == null)
                return true;

            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            //if there are odd nodes
            if (fast != null && fast.next == null)
            {
                slow = slow.next;
            }


            slow = Reverse(slow);
            fast = head;

            while (slow != null && fast != null)
            {
                if (slow.val != fast.val)
                {
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }

            return true;
        }

        public ListNode Reverse(ListNode head)
        {
            ListNode prev = null;
            ListNode curr = head;
            ListNode temp;

            while (curr != null)
            {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            return prev;
        }
    }
