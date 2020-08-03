# APPROACH  
# Time Complexity : O(n), n: length of linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None (initially used hashset to store and remove values from mid, but what if same values in different order exist ?)
#
#
# Your code here along with comments explaining your approach
# 1. Find mid point of the list
# 2. Reverse the second half. if odd length (mark it)
# 3. start compare the values (not nodes) from begining and middle. if not equal not palindrome. if at end 1st ptr is not None and odd (middle single element) and other - True


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        if head is None or head.next is None:
            return True
        
        slow, fast = head, head
        
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
          
        isOdd = False
        if fast is not None:
            slow = slow.next
            isOdd = True
            
        prev, curr, curr_next = None, slow, slow.next
        while curr_next is not None:
            curr.next = prev
            prev = curr
            curr = curr_next
            curr_next = curr_next.next
        curr.next = prev
        
        slow, fast = head, curr
        while fast is not None:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
            
        if slow.next is not None and isOdd or slow.next is None:
            return True
        else:
            return False
        
