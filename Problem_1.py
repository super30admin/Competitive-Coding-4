"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Finding the middle of the linked list using slow and fast pointer, then seperating the first two halves
and reversing the second part of linked list. Iterating both the parts from their head
checking if the values match, if yes, then its a palindrome linked list, if they don't, then its not a palindrome linked list

"""

# Palindrome Linked List

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

        if head==None or head.next==None:
            return head
        # finding the middle point of linked list
        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        
        
        head_l2=slow.next
        slow.next=None

        # reversing the other half of linked list

        prev=None
        curr=head_l2

        while curr!=None:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        # print(prev.val,head.val)
        # head at the prev
        if head.val!=prev.val:
            return False

        # iterating from both the ends

        while prev!=None:
            if head.val!=prev.val:
                return False
        
            head=head.next
            prev=prev.next
        return True