# Approach:
# 1. Use a two-pointer technique to find the middle of the linked list.
# 2. Reverse the second half of the linked list and compare it with the first half.
# 3. Restore the original structure of the list (optional) and return whether the two halves matched.

# Time Complexity: O(n), where n is the number of nodes in the linked list.
# Space Complexity: O(1), as we modify the list in place without using additional space.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True  # Single node or empty list is always a palindrome
        
        # Step 1: Find the middle of the linked list
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Reverse the second half
        prev = None
        while slow:
            next_node = slow.next
            slow.next = prev
            prev = slow
            slow = next_node
        
        # Step 3: Compare both halves
        first_half, second_half = head, prev
        while second_half:  # Compare till the end of the reversed half
            if first_half.val != second_half.val:
                return False
            first_half = first_half.next
            second_half = second_half.next
        
        # Step 4: (Optional) Restore the original structure of the list
        # Code for this can be added if needed
        
        return True
