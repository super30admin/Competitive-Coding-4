""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def __init__(self):
        self.flag = True

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return self.flag
        slow = head
        fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        while fast:
            if slow.val == fast.val:
                slow = slow.next
                fast = fast.next
            else:
                self.flag = False
                break
        return self.flag

    def reverse(self, head):
        prev = None
        curr = head
        fast = head.next

        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr

