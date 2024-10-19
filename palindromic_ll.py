# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return True

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        sec_half = self.reverseLl(slow)
        first_half = head

        while sec_half:
            if first_half.val != sec_half.val:
                return False

            first_half = first_half.next
            sec_half = sec_half.next
        return True

    def reverseLl(self, head):
        prev = None
        while head:

            next_node = head.next

            head.next = prev

            prev = head

            head = next_node

        return prev


# time complexity is O(n)
# space complexity is O(1)
