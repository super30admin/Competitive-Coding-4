# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Brute Force approach is reverse the linked list and store it.
# To optimize the space, first we need to find the middle element in the list
# Then reverse the second half of the list
# Then compare the first half value with the second half one by one
# If the value is not equal then return False else return True


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        head2 = slow
        while head2:
            currentNode = head2.next
            head2.next = prev
            prev = head2
            head2 = currentNode

        l1 = head
        l2 = prev
        while l2:
            if l1.val != l2.val:
                return False
            l1 = l1.next
            l2 = l2.next

        return True