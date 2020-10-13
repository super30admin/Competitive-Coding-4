# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
                
        # len = 0  or 1
        if not head or not head.next:
            return True        
        
        curr = head
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
          
        node = self._reverse(slow)
            
        while node and curr:
            if node.val != curr.val:
                return False
            node = node.next
            curr = curr.next
            
        return True
    
    def _reverse(self, head):
        
        prev = None
        while head:
            
            after = head.next
            head.next = prev
            prev = head
            head = after
            
        return prev
            
    
        
        