'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(h) -- recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def reverseLinkedList(self, head, previous = None, temp = None):
        
        while head != None:
            previous = head
            head = head.next
            previous.next = temp
            temp = previous
        
        head = previous
        return head
    
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        # return flag as result
        flag = True
        
        # Step 1: Find the mid
        # slow 1x 
        # fast 2x
        
        slow = head
        fast = head
        
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
            
        
        # Found my mid
        
        # Step 2: Reverse the linked list
        fast = self.reverseLinkedList(slow.next)
        
        # Step 3: Break the connection
        slow.next = None
        slow = head
        
        # Step 4: Perform check
        while fast != None:
            if fast.val == slow.val:
                fast = fast.next
                slow = slow.next
            else:
                flag = False
                break
            
            
        return flag
        