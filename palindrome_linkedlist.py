# Time Complexity : O(N) where N is number of nodes in the linkedlist
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        m = 1
        while fast.next is not None and fast.next.next is not None:
            m += 1
            slow = slow.next
            fast = fast.next.next
            
        end = self.reverse(slow)
        slow = head
        if m == 1:
            return True if slow.val == end.val else False

        i = 1
        while i < m and end is not None:
            if slow.val == end.val:
                slow = slow.next
                end = end.next
            else:
                return False
            i += 1
        
        return True
        
    def reverse(self, node):
        prev = None
        curr = node
        lead = node.next
        
        while curr.next is not None:
            curr.next = None
            prev = curr
            curr = lead
            lead = lead.next
            
        curr.next = prev
        
        return curr