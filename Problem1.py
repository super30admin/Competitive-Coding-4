# https://leetcode.com/problems/palindrome-linked-list/
# Time Complexity: O(n), we traverse the list a constant number of times (find middle, reverse half, compare halves)
# Space Complexity: O(1), we only use pointers (slow, fast, previous, current), no extra data structures
# Approach: Use slow/fast pointers to find the middle of the list without knowing its length upfront.
# Reverse the second half in-place (skipping the middle node so odd-length lists work correctly).
# Compare the first half against the reversed second half value-by-value.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head         # slow will end up at the middle node
        fast = head         # fast moves 2 steps at a time, so it reaches the end when slow reaches the middle

        # loop until fast can't take 2 more steps, this means fast has hit (or passed) the end,
        # and at that exact moment slow is guaranteed to be sitting on the middle node
        while fast.next is not None and fast.next.next is not None:  # works for both even and odd length lists
            slow = slow.next            # advance slow by 1
            fast = fast.next.next       # advance fast by 2

        # reverse starting from slow.next (NOT slow itself), this deliberately skips the middle node,
        # so for odd-length lists the unpaired center element is excluded from the comparison entirely
        reversed_order = self.reverse(slow.next)

        slow = head                 # reset slow back to the very start, this is now "pointer 1" for comparison
        fast = reversed_order       # fast now walks the reversed second half, this is "pointer 2" for comparison

        # walk both halves together, loop naturally stops when the shorter reversed half runs out,
        # so we never need to worry about list length parity here
        while slow is not None and fast is not None:
            if slow.val != fast.val:    # mismatch found, it can't be a palindrome
                return False
            slow = slow.next        # move pointer 1 forward through the first half
            fast = fast.next        # move pointer 2 forward through the reversed second half
        return True                 # all values matched, it is a palindrome

    def reverse(self, node):
        previous = None                # this will become the new head of the reversed sublist
        current = node                 # current is the node we're processing right now

        while current is not None:
            temperory = current.next   # save the next node before we overwrite current.next
            current.next = previous    # flip the pointer, current now points backward
            previous = current         # previous advances to current
            current = temperory        # current advances to the saved next node
        return previous                # once current is None, previous is sitting on the new head