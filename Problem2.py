# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=head
        fast=head
        Flag=True
        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next
        
        curr=slow.next
        prev=None
        while(curr!=None):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        
        slow.next=None
        fast=prev
        slow=head

        while(fast!=None):
            if slow.val!=fast.val:
                Flag=False
            slow=slow.next
            fast=fast.next
        
        return Flag