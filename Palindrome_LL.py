"""
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverse(self,root): #function to reverse a LL
        
        prev = None
        cur = root
        fast = cur.next
        
        while fast:
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        cur.next = prev
        
        return cur
        

    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        
        if not head or not head.next:
            return True
        slow = head
        fast = head
        
        while fast.next and fast.next.next: #finding mid of LL
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next) #reversing the second half of the LL
        
        slow.next = None
        
        slow = head
        
        while slow and fast: #iteratin over both the lists, if LL is a palindrome, the first half and the reverse of the second half would be same 
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
            
        return True