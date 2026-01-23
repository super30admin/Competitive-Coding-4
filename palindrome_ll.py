"""
time - o(n)
space o(1)
we use fast and slow pointers to find the middle of the linked list, we then split it at the middle and reverse the second half
we then compare the two halves one node at a time to see if they are a palindrome
"""
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverse_linkedlist(self, head):
        prev = None
        curr = head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head.next == None:
            return True
        slow = fast = head
        while fast and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        reversed_head = self.reverse_linkedlist(slow)
        p1 = head
        p2 = reversed_head
        while p2:
            if p1.val != p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        return True

        
        