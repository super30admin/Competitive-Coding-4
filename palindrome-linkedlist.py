# Time Complexity: O(n)
# Space Complexity: O(1)
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
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        mid = slow
        prev = None
        
        while mid:
            nxt = mid.next
            mid.next = prev
            prev = mid
            mid = nxt
        
        while prev:
            if prev.val != head.val:
                return False
            prev = prev.next
            head = head.next
        return True