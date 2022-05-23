using System;
using System.Collections.Generic;
using static Algorithms.Linked_List_Reverse;

namespace Algorithms
{
    public class LinkedList_IsPalindrome
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 

        public bool IsPalindrome(ListNode head)
        {

            if (head == null) return false;
            ListNode node = head;
            bool isPalindrome = true;
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode secondHalfReversed = reverse(slow.next);

            while (secondHalfReversed != null)
            {
                if (head.val == secondHalfReversed.val)
                {
                    isPalindrome = true;
                }
                else
                {
                    isPalindrome = false;
                    break;
                }
                head = head.next;
                secondHalfReversed = secondHalfReversed.next;
            }

            return isPalindrome;

        }

        private ListNode reverse(ListNode head)
        {
            if (head == null) return head;
            ListNode prev = null;
            ListNode current = head;
            ListNode fast = head.next;

            while (fast != null)
            {
                current.next = prev;
                prev = current;
                current = fast;
                fast = fast.next;
            }

            current.next = prev;
            return current;
        }


        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public bool IsPalindrome_Stack(ListNode head)
        {

            if (head == null) return false;
            ListNode node = head;
            bool isPalindrome = true;
            Stack<int> st = new Stack<int>();
            while (node != null)
            {
                st.Push(node.val);
                node = node.next;
            }

            while (head != null)
            {
                int i = st.Pop();
                if (head.val == i)
                {
                    isPalindrome = true;
                }
                else
                {
                    isPalindrome = false;
                    break;
                }
                head = head.next;
            }
            return isPalindrome;

        }

    }
}
