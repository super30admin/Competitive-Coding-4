# Time Complexity : O(N)
# Space Complexity : O(1) not sure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head == None:
            return True
        
        #Find the middle node of the linked list
        dummy = ListNode(0)
        dummy.next = head
        slow = dummy
        fast = dummy
        
        while fast!=None and fast.next!=None:
            slow = slow.next
            fast = fast.next.next
        
        second = self.reverseList(slow.next)
        slow.next = None
        first = dummy.next
        
        while(second!=None):
            if first.val!=second.val:
                return False
            
            first = first.next
            second =second.next
            
    
        return True
            
        
    def reverseList(self, node):
        
        R = None
        cursor = node
        
        while(cursor!=None):
            next = cursor.next
            cursor.next = R
            R = cursor
            cursor = next
            
        return R
            