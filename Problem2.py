# 234. Palindrome Linked List
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        
        def reverse(node):
            prev = None
            curr = node
            
            while curr != None:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev
        
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            
        fast = reverse(slow)
        slow.next = None
        slow = head
        
        while slow.next != None :
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
            
        return True
        