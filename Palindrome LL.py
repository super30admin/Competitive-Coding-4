# Time complexity : O(n)
# Space complexity : O(1)
# The code ran on Leetcode

# Reverse second half of the linked list and check if it is same as the first half
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Get mid point of the linked list
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        new_head = slow

        # Reverse the second half of the linked list

        def reverse(head):
            if head == None or head.next == None:
                return head

            reversed = reverse(head.next)

            head.next.next = head
            head.next = None

            return reversed

        reversed_head = reverse(new_head)

        # Check if first half and reverse of second half are same
        first = head; second = reversed_head

        while first and second:
            if first.val == second.val:
                first = first.next
                second = second.next
            else:
                return False
        return True
