# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
"""
TC: O(n)
SC: o(1)
"""
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        prev, curr = None, slow
        
        while curr:
            curr.next, prev, curr = prev, curr, curr.next
        
        first, second = head, prev
        
        while second :
            if first.val != second.val:
                return False
            
            first = first.next
            second = second.next
            
        return True
                
        
