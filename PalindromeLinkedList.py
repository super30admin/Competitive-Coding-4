"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        result = []
        current = head
        # We traverse through the list and append the list
        # and then reverse it and compare
        while current is not None:
            result.append(current.val)
            current = current.next
        return result == result[::-1]