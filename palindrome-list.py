# Time Complexity: O(n)
# Space Complexity: O(1)
# Approach: Find the mid using Floyd's algo and reverse the second half of the list in place.
# Traverse the list and the reversed half and compare elements.

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
        first = head
        second = self.reverse(self.get_mid(first))
        while second:
            if first.val != second.val:
                return False
            second = second.next
            first = first.next
        return True
    
    def get_mid(self, head):
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
        return slow
    
    def reverse(self, head):
        curr = head
        prev, next = None, None
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev
    