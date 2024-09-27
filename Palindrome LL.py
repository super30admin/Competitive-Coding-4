# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def isPalindrome(self, head):
        
        dummy = ListNode(0)
        dummy.next = head
        
        slow = dummy
        fast = dummy
        
        # to find mid point
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse 2nd LL
        second = self.reverse(slow.next)
        
        # check the values
        while second:
            if head.val!=second.val:
                return False
            head = head.next
            second = second.next
            
        return True            
    
    def reverse(self,curr):
        prev = None
        while curr:
            forw = curr.next
            curr.next = prev
            prev = curr
            curr = forw  
        return prev
               