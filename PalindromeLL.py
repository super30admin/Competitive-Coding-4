# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Since we cannot traverse backwards as it is a singly linked list. We use 2 pointers slow and fast(p1 and p2) pointers
# to determine the mid and then reverse the other half of the linked list and then bring back slow pointer to head.
# Check each value if it doesn't match return False

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        p1 = head
        p2 = head
        while (p2.next != None and p2.next.next != None):
            p1 = p1.next
            p2 = p2.next.next

        p2 = self.reverseLL(p1.next)
        p1.next = None
        p1 = head

        while (p1 and p2):
            if (p1.val != p2.val):
                return False
            p1 = p1.next
            p2 = p2.next
        return True

    def reverseLL(self, node):
        prev = None
        curr = node
        while (curr):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev
