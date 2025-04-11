"""
Approach:
Find the middle of the linked list using slow and fast pointers.
Reverse the second half of the list in-place.
Use two pointers: one from the start and one from the reversed half to compare values.
If all nodes match → return True; else → False.

T.C: O(n)

S.C: o(1)

Passed in leetcode : Yes
"""
from typing import List, Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head

        #middle point
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        #reverse second half
        prev = None
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
        
        #check palindrome
        left = head
        right = prev
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True

sol = Solution()
head = ListNode(1, ListNode(2))
print(sol.isPalindrome(head))