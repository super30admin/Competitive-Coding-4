"""
Problem: 234. Palindrome Linked List
Leetcode: https://leetcode.com/problems/palindrome-linked-list/
Time Complexity: O(n), all nodes are traversed once in each function
Space Complexity: O(1), only pointers are used, no extra space
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # base case
        if not head:
            return True

        # Find the end of first half
        first_half_end = self.end_of_first_half(head)
        # Reverse the second half
        second_half_start = self.reverse_list(first_half_end.next)

        # check palindrome
        first_position = head
        second_position = second_half_start
        while second_position:
            if first_position.val != second_position.val:
                return False
            first_position = first_position.next
            second_position = second_position.next

        # Restore the list and return the result.
        first_half_end.next = self.reverse_list(second_half_start)
        return True

    # find the end of first half
    def end_of_first_half(self, head):
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    # reverse the second half
    def reverse_list(self, head):
        prev = None
        curr = head
        while curr:
            curr.next, prev, curr = prev, curr, curr.next
        return prev

