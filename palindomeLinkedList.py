# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had issues with one or two nodes..
#  Didn't realize it was because of my base case that it had to be 
# "if not head or not head.next:""



# Your code here along with comments explaining your approach


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # """
        # Can put values into an array and check if that array is a palindrome
        # TC: O(N)
        # SC: O(N)
        # """
        # if not head:
        #     return True
        
        # arr = []
        
        # curr = head
        
        # while curr:
        #     arr.append(curr.val)
        #     curr = curr.next 
            
        # return arr == arr[::-1]
        """
        Need to do O(1) space... 
         - Gonna have to do some tricks
         Find midpoint
            - reverse from mid to end of list
            - check if palindrome
        """
        if not head or not head.next:
            return True
        
        slow = head
        fast = head
        #find mid 
        while fast.next and fast.next.next:
            slow = slow.next 
            fast = fast.next.next
        
        #reverse from mid to end of list
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        
        
        #check if palindrome
        while slow and fast:
            if slow.val != fast.val:
                return False
            slow = slow.next 
            fast = fast.next 
        
        return True
    
    def reverse(self, head):
        prev = None
        curr = head
        fast = head.next 
        
        while fast:
            curr.next = prev 
            prev = curr
            curr = fast
            fast = fast.next 
        
        curr.next = prev 
        
        return curr
        
    
    
    
    
    
    
    
    