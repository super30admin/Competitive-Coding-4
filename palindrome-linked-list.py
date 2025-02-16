# Time Complexity : O(n) - n is number of elements in linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Find the middle
Reverse the second half
Traverse through first and reversed second half to check all the element values are same
For odd length, first half list would have one elemnet more
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):

    def reverse(self, root):
        prev = None
        current = root

        while current is not None:
            tmp = current.next
            current.next = prev
            prev = current
            current = tmp

        return prev


    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """

        # find the middle
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        # reverse the second half
        fast = self.reverse(slow.next)
        slow.next = None

        slow = head

        # traverse through both the halves
        while fast is not None:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next

        return True



















