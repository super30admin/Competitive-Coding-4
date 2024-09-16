# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Leetcode problem link : https://leetcode.com/problems/palindrome-linked-list/
# Time Complexity : O(n)
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : O(n) => Copy all the elements into an array and check palindrome using mid of array
    
        Optimized approach: O(1) space => The intuition behind this approach is plaindrome is same reading forwards and backwards but as we cant go back in linked list. 
        1. Find the midpoint as palindrome needs to be compared as first half wth second half.
        2. Get midpoint to compare
        3. Reverse second half of the list
        4. Compare values for both head pointers
        
'''
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        #1. find midpoint
        mid = self.__findMid(head)
        # 2 . Reverse second half
        head2 = self.__reverse(mid)
        head1 = head
        # compare both halves
        while(head1 and head2):
            if head1.val !=head2.val:
                return False
            head1 = head1.next
            head2 = head2.next
        return True
    
    def __findMid(self,root):
        if not root:
            return None
        slow = root
        fast = root
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
    
    def __reverse(self,root):
        if not root:
            return None
        prev = None
        curr = root
        next = None
        while(curr):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        return prev
