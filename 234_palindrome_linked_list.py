# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        """
            // Time Complexity : O(n)
            // Space Complexity : O(1)
            // Three line explanation of solution in plain english :
                - Find the mid (slow and fast pointer)
                - Reverse from mid
                - Traverse the reversed and the first half
        """
        if not head or not head.next:
            return True
        # mid
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # slow is at mid
        # reverse
        prev = None
        current = slow
        fast = None
        while current:
            fast = current.next
            current.next = prev
            prev = current
            current = fast

        # check palindrome
        fast = prev
        slow = head
        while slow != fast:
            if slow.val != fast.val:
                return False
            if slow.next == fast:
                break
            slow = slow.next
            fast = fast.next
        return True
