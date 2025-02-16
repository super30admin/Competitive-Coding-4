# Problem 1 :  Palindrome Linked List
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        # finding the  middle element using slow and fast pointer
        slow, fast = head, head
        while (fast.next is not None and fast.next.next is not None):
            # slow pointer moves by one position and fast pointer moves by 2 position
            slow = slow.next 
            fast = fast.next.next
        
        # reverse second half of the list 
        # slow pointer will point to last element of the list
        middle = slow.next 
        # initialize the prev pointer to None
        prev = None
        while (middle is not None):
            temp = middle.next 
            middle.next = prev
            prev = middle 
            middle = temp

        # set the next pointer of last element of the first half to None 
        slow.next = None

        # set the firstPointer to first list and secondPointer to second list
        firstPointer = head
        secondPointer = prev
        # loop till both pointer is not None
        while (firstPointer is not None and secondPointer is not None):
            # if the value of the two pointers are equal then increment both the pointer
            if (firstPointer.val == secondPointer.val):
                firstPointer = firstPointer.next
                secondPointer = secondPointer.next
            # else return false
            else:
                return False
        return True
        
        