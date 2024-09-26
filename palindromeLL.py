'''
Time Complexty: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        length=0
        hCount=head
        fast=head
        while hCount.next and hCount.next.next:
            hCount=hCount.next.next
            fast=fast.next
        #reverse
        prev=None
        while fast:
            current=fast
            fast=fast.next
            current.next=prev
            prev=current
        
        while prev and prev.next:
            if head.val!=prev.val:
                return False
            head=head.next
            prev=prev.next
        return True
        