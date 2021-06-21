
"""
Approach: reverse the second half of the linked list and check if the node values are same at each node

TC: O(n)
SC: O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head.next:
            return True

        slow = head
        fast = head
        prev = None

        while fast and fast.next:
            fast = fast.next.next
            # slow = slow.next
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        # check for odd/even length
        if fast:
            slow = slow.next

        # check 1st and 2nd half of given ll
        while prev and slow:
            if prev.val != slow.val:
                return False
            slow = slow.next
            prev = prev.next
        return True
