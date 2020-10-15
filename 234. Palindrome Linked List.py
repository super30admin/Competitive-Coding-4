"""
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        """
        Run Time Complexity: O(N)
        Space Complexity : O(1)
        
        
        Find the mid.
        Divide at the mid and reverse any one half.
        No compare each element in both the indexes until any one reaches at end.
        
        """
        
        if not head:
            return True
        
        slow = head
        fast = head
        while(fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        head2 = slow
        
        head2 = self.rev(head2)
        
        while(head2 != None or head != None):
            if(head.val != head2.val):
                return False
            head = head.next
            head2 = head2.next
        
        return True
    
    def rev(self, head):
        prev = None
        while(head != None):
            node2 = head.next
            head.next = prev
            prev = head
            head = node2
        return prev
            
            
        
        