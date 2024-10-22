# Time Complexity = O(n) | Space Complexity = O(1)

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = head
        fast = head
        # middle and reversing
        prev = None
        while fast and fast.next:
            fast = fast.next.next
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        # edge case if fast node is not at end include one more node
        if fast:
            slow = slow.next

        while slow and prev:
            if slow.val != prev.val:
                return False
            slow = slow.next
            prev = prev.next

        return True




