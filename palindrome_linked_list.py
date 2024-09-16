# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def findMid(self, head):
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow.next
    
    def reverse(self, head):
        if not head:
            return head
        prev = None
        curr = head
        fast = head.next
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
    
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        mid = self.findMid(head)
        second = self.reverse(mid)
        while second:
            if head.val != second.val:
                return False
            head = head.next
            second = second.next
        return True
        
        
        