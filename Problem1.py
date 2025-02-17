# 234. Palindrome Linked List

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use two pointers to find the middle of the linked list.
# Reverse the second half of the linked list.
# Compare the first half and the second half.

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head or not head.next:
            return True
        
        # Find the middle of the linked list
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the linked list
        slow = self.reverse(slow)
        fast = head

        # Compare the first half and the second half
        while slow:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next

        return True
    
    def reverse(self, head):
        prev = None
        curr = head

        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        return prev
        
        