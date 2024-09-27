"""
//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
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
        while(fast!=None and fast.next!=None):
            slow= slow.next
            fast = fast.next.next
            
        fast = head
        slow = self.reverseList(slow)
        while(slow !=None):
            if(slow.val!=fast.val):
                return False
            slow=slow.next
            fast=fast.next
        return True
    def reverseList(self,slow):
        prev = None
        curr = slow
        while(curr!=None):
            Next = curr.next
            curr.next = prev
            prev = curr
            curr = Next
        return prev
       
        