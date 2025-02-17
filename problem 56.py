#  https://leetcode.com/problems/palindrome-linked-list/

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        dummy = ListNode(-1)
        dummy.next = head
        slow = dummy
        fast = dummy

        # moving pointers to find mid O(n)
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        # sever link and reverse linked list
        fast = self.reverse(slow.next)
        slow.next = None

        slow = head
        # compare

        while fast != None: #O(n)
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
        
        return True


    def reverse(self, head: Optional[ListNode]):# O(n)
        curr = head
        prev = None

        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev
        
