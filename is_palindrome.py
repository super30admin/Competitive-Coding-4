# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time: O(N)
# Space: O(1)
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head: return True
        if not head.next: return True

        # Get to the end of the first half
        first_half_end = self.getFirstHalfEnd(head)
        # print(first_half_end)

        # Reverse the second half
        second_half_rev_head = self.reverseLinkedList(first_half_end.next)
        # print(second_half_rev_head)

        # Compare two halves
        result = True
        first_head, second_head = head, second_half_rev_head
        while second_head:
            if first_head.val != second_head.val:
                result = False
            first_head = first_head.next
            second_head = second_head.next

        #         first_half_end.next = self.reverseLinkedList(second_half_rev_head)

        #         while head:
        #             print(head.val)
        #             head = head.next

        return result

    def getFirstHalfEnd(self, head):
        slow, fast = head, head
        while fast and fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def reverseLinkedList(self, node):
        prev = None
        current = node
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return prev