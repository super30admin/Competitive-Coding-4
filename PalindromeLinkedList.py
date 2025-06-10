# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
#  idea is to find middle reversse the middle part and then compare the two halves

# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow,fast = head ,head

        def reversed(curr):
            prev = None
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev

        # find midd 
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        fast = reversed(slow.next)
        slow.next = None
        slow = head 
        # compare
        while fast and slow:
            if slow.val!=fast.val:
                return False
            slow=slow.next
            fast = fast.next
        return True
        

        
        