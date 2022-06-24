# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# # // Time Complexity : O(N//2) (for traversing the first half) +O(N//2)(For reversing the LL ) + O(N//2) (for joining) = O(N)
# # // Space Complexity : O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        slow = head
        fast = head

        while (fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next

        midPoint = slow

        # Reverse the linkedList
        prev = None
        current = midPoint.next
        midPoint.next = None

        while (current != None):
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        secondHalf = prev
        firstHalf = head

        while firstHalf and secondHalf:
            if firstHalf.val != secondHalf.val:
                return False

            firstHalf = firstHalf.next
            secondHalf = secondHalf.next
        return True