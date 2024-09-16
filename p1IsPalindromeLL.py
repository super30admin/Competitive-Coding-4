from tkinter import ON



"""
// Time Complexity : ON
// Space Complexity : O(N/2)
// Did this code successfully run on Leetcode : y
// Any problem you faced while coding this : n
"""


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

            if not head or not head.next:
                return True

            # 1. Get the midpoint (slow)
            slow = fast = cur = head
            while fast and fast.next:
                fast, slow = fast.next.next, slow.next
            
            # 2. Push the second half into the stack
            stack = [slow.val]
            while slow.next:
                slow = slow.next
                stack.append(slow.val)

            # 3. Comparison
            while stack:
                if stack.pop() != cur.val:
                    return False
                cur = cur.next
            
            return True