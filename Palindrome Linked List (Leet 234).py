# Time Complexity: O(N)
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:\
        
        if head is None or head.next is None:
            return True
        
        slow, fast = head, head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        
        while fast != None and slow != None:
            if fast.val != slow.val:
                return False
            fast = fast.next
            slow = slow.next
            
        return True
        
        
    def reverse(self, root):
        prev = None
        curr = root
        fast = curr.next
        
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
        
        