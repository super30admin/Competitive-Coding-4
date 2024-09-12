'''
Time complexity: O(n)
Space complexity: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None:
            return True
        slow = head
        fast = head.next
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        head2 = slow.next
        slow.next = None
        
        prev = None
        current = head2
        while current:
            next = current.next
            current.next = prev
            prev = current
            current = next
        head2 = prev
        
        while head and head2:
            if head.val != head2.val:
                return False
            else:
                head = head.next
                head2 = head2.next
        return True
        