# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        if not head:
            return True
        
        slow = head
        fast = head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next)
        #slow.next = None
        slow = head
        
        while fast:
            if slow.val != fast.val:
                return False
            
            slow = slow.next
            fast = fast.next
            
        return True
    
    def reverse(self, root):
        prev = None
        curr = root
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        return prev