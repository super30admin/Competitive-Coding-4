# Reverse the second half in place and compare with two pointers from beginning and mid
# TC: O(N)
# SC: O(1)
# Yes, this worked in leetcode

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        if head is None:
            return True
        first_half_end = self.end_of_first_half(head)
        second_half_start = self.reverse_list(first_half_end.next)

        result = True
        first_position = head
        second_position = second_half_start
        while result and second_position is not None:
            if first_position.val != second_position.val:
                result = False
            first_position = first_position.next
            second_position = second_position.next

        first_half_end.next = self.reverse_list(second_half_start)
        return result    

    def end_of_first_half(self, head: ListNode) -> ListNode:
        fast = head
        slow = head
        while fast.next is not None and fast.next.next is not None:
            fast = fast.next.next
            slow = slow.next
        return slow

    def reverse_list(self, head: ListNode) -> ListNode:
        previous = None
        current = head
        while current is not None:
            next_node = current.next
            current.next = previous
            previous = current
            current = next_node
        return previous
        # if not head or not head.next:
        #     return True
        # initial = head
        # prev = None
        # curr = head
        # fast = head.next
        # while fast:
        #     curr.next = prev
        #     prev = curr
        #     curr = fast
        #     fast = fast.next
        # curr.next = prev

        # while initial and curr:
        #     if initial.val != curr.val:
        #         return False
        #     initial = initial.next
        #     curr = curr.next
        # return True