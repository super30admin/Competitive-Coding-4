# Time complexity: O(N)
# Space Complexity: O(1)
# Passed Leetcode

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def find_mid(self, head):
        slow = head
        fast = head
        
        while fast and fast.next:
            
            slow = slow.next
            fast = fast.next.next
        
        return slow
    
    def reverse(self, head):
        
        p1 = None
        # p2 = head.next
        
        # p1.next = None
        
        while head:
            
            temp = head.next
            
            head.next = p1
            
            p1 = head 
            head = temp
        
        return p1
    
    
    def compare(self, head, rev_head):
        
        
        while rev_head:
            
            if head.val != rev_head.val:
                return False
            
            head = head.next
            rev_head = rev_head.next
        return True
            
    
    def isPalindrome(self, head: ListNode) -> bool:
        
        
        if not head or not head.next:
            return True
        
        mid_element = self.find_mid(head)
        
        
        reversed_head = self.reverse(mid_element)
         
        
        return self.compare(head, reversed_head)