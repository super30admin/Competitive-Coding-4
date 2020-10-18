# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        def reverse(root):
            prev = None
            current = root
            while current is not None:
                nextNode = current.next
                current.next = prev
                prev = current
                current = nextNode
            return prev
        
        if head is None or head.next is None:
            return True
        
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        slowCopy = slow
        
        reverseList = reverse(slow.next)
        slowCopy.next = reverseList
        
        slowCopy = slowCopy.next
        
        while slowCopy is not None:
            if head.val != slowCopy.val:
                return False
            head = head.next
            slowCopy = slowCopy.next
        return True
