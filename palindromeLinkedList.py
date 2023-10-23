# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        slow = head
        fast = head
        # finding mid
        while (fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        slow = slow.next
        # reverse the list
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        # check the nodes, reverse list my head is at prev
        while prev:
            if head.val != prev.val: return False
            head = head.next
            prev = prev.next
        return True

