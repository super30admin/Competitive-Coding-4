'''
Time Complexity: O(n)
Space Complexity: O(1)
Run on Leetcode: YES
'''
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverse(self, head) -> ListNode:
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # handling single element linked list
        if head.next == None:
            return True
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        #reversing
        fast = self.reverse(slow.next)
        slow.next = None
        flag = False
        #checking for palindrome
        slow = head
        while(fast != None):
            if fast.val != slow.val:
                return flag
            fast = fast.next
            slow = slow.next
        return True