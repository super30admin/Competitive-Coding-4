# 234. Palindrome Linked List
# https://leetcode.com/problems/palindrome-linked-list/

# Time Complexiety: O(n)
# Space Complexiety: O(1)

# Logic: Find the mid-point, reverse all nodes after the mid-point, compare all the values from head and head2

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head):
        prev, cur = None, head
        
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        return prev
    
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Find mid point
        slow, fast = head, head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        if not fast:
            head2 = slow
        else:
            head2 = slow.next
        
        # reverse 2nd Half
        head2 = self.reverse(head2)
        
        # Compare values from 1st and 2nd half
        while head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True