# Time Complexity: O(2n), where n is the number of nodes in the linked list.
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. Use the fast and slow pointer technique to find the middle of the linked list.
# 2. Reverse the second half of the linked list.
# 3. Start comparing the first half and the reversed second half of the linked list.
# 4. If all values are equal, return True. Otherwise, return False.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head) -> bool:
        # Initialize slow and fast pointers to head
        slow, fast = head, head

        # Move slow pointer one step and fast pointer two steps until fast reaches the end
        # This will give us the middle of the linked list
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
    
        # Reverse the second half of the linked list
        prev = None
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
        # Now, prev points to the head of the reversed second half
        # Compare the first half and the reversed second half of the linked list
        while head and prev:
            if head.val != prev.val:
                return False
            head = head.next
            prev = prev.next
        # If we reach here, it means all values were equal and the linked list is a palindrome
        # Return True
        return True