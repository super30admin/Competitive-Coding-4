# Time Complexity : O(n)
# Space Complexity: O(1)
# Approach to solve this problem: Given Below

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast, slow = head, head
        
        # Finding the mid of the list
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
        # reverse the second half
        prev = None
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
            
        # Check the palindrome
        left, right = head, prev
        while right:
            if left.val != right.val:
                return False
            
            left = left.next
            right = right.next
        return True
        