# Time Complexity : O(n)
# Space Complexity : O(1), constant space is used.
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        # Optimized Approach: Reverse second half and compare
        if not head or not head.next:
            return True

        def end_of_first_half(node):
            slow = node
            fast = node
            while fast.next and fast.next.next:
                slow = slow.next
                fast = fast.next.next
            return slow

        def reversed_list(node):
            prev = None
            curr = node
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev

        # Step 1: Find end of first half
        first_half_end = end_of_first_half(head)

        # Step 2: Reverse second half
        second_half_start = reversed_list(first_half_end.next)

        # Step 3: Compare both halves
        p1 = head
        p2 = second_half_start
        result = True
        while p2:
            if p1.val != p2.val:
                result = False
                break
            p1 = p1.next
            p2 = p2.next

        # Optional: Restore the list (not required by Leetcode)
        # first_half_end.next = reversed_list(second_half_start)

        return result

# ------------------------------------------------------------------------------------------

        # Naive Approach
        # Time Complexity: O(n)
        # Space Complexity: O(n) to store node values in a list

        # values = []
        # while head:
        #     values.append(head.val)
        #     head = head.next

        # left = 0
        # right = len(values) - 1
        # while left < right:
        #     if values[left] != values[right]:
        #         return False
        #     left += 1
        #     right -= 1

        # return True
