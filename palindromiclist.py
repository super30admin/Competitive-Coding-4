"""
Problem: Palindromic linked list
Approach: reverse the second half of the list and check if head and tail are equal or not.
t.c. => O(n)
s.c. => O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head.next
        tail = None
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        tail = slow.next
        slow.next = None
        prev = None
        while tail:
            nxt = tail.next
            tail.next = prev
            prev = tail
            tail = nxt
        tail = prev

        while head and tail:
            if head.val != tail.val:
                return False
            head = head.next
            tail = tail.next
        return True