# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Use fast and slow pointers to find the middle of the linked list.
# Reverse the second half of the list in-place starting from the middle.
# Compare nodes from the start and from the reversed second half to check for palindrome.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        fast = slow = head

        # find the middle
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        # reverse the second half
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        
        # check
        while head and prev:
            if head.val != prev.val:
                return False
            else:
                head = head.next
                prev = prev.next
        return True