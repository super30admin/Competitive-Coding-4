# 234. Palindrome Linked List

# code:


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        if not head or not head.next:
            return True
        
        slow = head
        fast = head
        q = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        p = self.reverse(slow)
        while p and q:
            if p.val!=q.val:
                return False
            p = p.next
            q = q.next
        
        return True
            
        
    def reverse(self, head):
        if not head:
            return None
        
        prev = None
        nxt = None
        curr =head
        
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        return prev

# Time complexity: O(3n/2)
# Space complexity: O(1)
# Accepted on Leetcode: Yes