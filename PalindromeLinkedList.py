'''
TC: O(n)
SC: O(1)
'''
# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # find mid
        l = 0
        dummy = ListNode(-1, head)
        s,f = dummy, dummy
        while f and f.next:
            s = s.next
            f = f.next.next
            l += 2
        if not f:
            l -= 1

        #Split LL
        list1 = dummy.next
        list2 = s.next
        s.next = None
        
        #Reverse
        prev = None
        c,f = dummy.next, dummy.next
        while(c):
            f = f.next
            c.next = prev
            prev = c
            c = f
        list1 = prev

        if l%2 != 0:
            list1 = list1.next
        
        #Compare
        while list1 and list2:
            if list1.val!=list2.val:
                return False
            list1 = list1.next
            list2 = list2.next
        return True