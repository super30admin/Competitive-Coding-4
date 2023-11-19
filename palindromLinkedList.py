# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next



class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # null
        if not head:
            return False

        # first step - Divide the Linkedlist
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        # alternate approach
        # slow = head
        # fast = head.next

        # while fast is not None and fast.next is not None:
        #     slow = slow.next
        #     fast = fast.next.next
        
        secHead = slow.next
        slow.next = None

        # Second - reversing th secons half
        prev = None
        curr = secHead
        while curr:
            nx = curr.next
            curr.next = prev
            prev = curr
            curr = nx
        
        # iterating over both the linkedlists

        secHead = prev

        while head and secHead:
            if head.val != secHead.val:
                return False
            
            head = head.next
            secHead = secHead.next
        
        if head and head.next is not None:
            return False
        
        return True




