# Time Complexity: O(N) 
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = head
        fast = head
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        a = None
        while slow:
            temp = slow.next
            slow.next = a
            a = slow
            slow = temp
        
        first = head
        second = a
        
        while second:
            if first.val != second.val:
                return False
            first = first.next
            second = second.next
            
        return True