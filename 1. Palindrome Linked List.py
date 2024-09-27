# Time Complexity - O(n)
# Space Complexity - O(1)

class Solution:
    def isPalindrome(self, head) -> bool:
        fast = head
        slow = head

        # Find the middle (slow)
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse Second Half of the linked List
        prev = None
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp

        # Check Palindrome
        left, right = head, prev
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True
