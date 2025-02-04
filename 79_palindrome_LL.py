# Time complexity - O(n)
# Space complexity - O(1)

# Approach - Create slow and fast pointer to get to the mid node. For the second half of the LL, reverse
# the LL and then compare the first half of the original LL to reversed LL.

from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None:
            return True
        
        slow = head
        fast = head

        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        # reverse
        prev = None
        curr = slow
        fast = curr.next

        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        rev_head = curr
        # print(rev_head.val)

        while rev_head != None:
            if head.val != rev_head.val:
                return False
            head = head.next
            rev_head = rev_head.next
        
        return True