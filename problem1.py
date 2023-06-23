"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach
Problem_1: https://leetcode.com/problems/palindrome-linked-list/
"""

# Approach - 1
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        """
        Dividing the linked list in two parts from the middle node then reverse the seconf half of the LL. Now, 
        compare both ll
        TC: O(N)
        SC: O(1)
        """
        if not head or not head.next: return True
        
        # take the mid node of the linked list
        mid_node = self.findMiddle(head)
        
        # reverse the second half of the linked list
        temp = self.reverse(mid_node.next)
        
        node = head
        while temp:
            if node.val != temp.val:
                return False
            node = node.next
            temp = temp.next
         
        return True
              
    def reverse(self, head):
        curr= head
        prev = None
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        return prev
        
    def findMiddle(self,head):
        slow = head
        fast = head
        
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            
        return slow
