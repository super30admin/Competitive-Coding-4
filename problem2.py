# https://leetcode.com/problems/palindrome-linked-list/

# Time Complexity : O(N) where N is the number of nodes on the linkedlist
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, couples of issues while reversing the list, fixed it later.


# Your code here along with comments explaining your approach

# Approach : First we find the center of the linkedlist using slow and fast pointer.
# And we reverse the list from the center. and start comparing the two lists.
# If they both are equal we return true else we return false.

from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False
        # Center
        slow = head
        fast = head.next
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        # found center, reverse the list now
        fast = self.reverse_linkedlist(slow.next)
        slow = head

        # Now compare both two lists.
        while fast is not None:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next

        return True

    def reverse_linkedlist(self, head):
        prev, next_pointer = None, None
        cur = head

        while cur is not None:
            print("In Reverse: ", cur.val)
            next_pointer = cur.next
            cur.next = prev
            prev = cur
            cur = next_pointer

        return prev
