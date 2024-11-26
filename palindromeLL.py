# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# find the middle of the list, reverse the second half and 
# compare the first half to the reversed second half


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val 
        self.next = None


class Solution:

    def reverseLL(self, head):

        if head is None or head.next is None:
            return head 
        rev = self.reverseLL(head.next) 
        head.next.next = head 
        head.next = None 
        return rev 
    
    def isPalindrome(self, head):

        if head is None or head.next is None:
            return True
        
        slow = head   
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next 
        
        rev = self.reverseLL(slow.next)  
        slow = head   
        fast = rev 

        while slow is not None and fast is not None:

            if slow.val != fast.val:
                return False 
            slow = slow.next 
            fast = fast.next 
        return True