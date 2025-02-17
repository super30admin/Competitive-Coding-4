# Approach:
# Use fast and slow pointers to find the middle of the linked list, then reverse the second half.
# Compare the reversed second half with the first half to check for palindrome properties.
# Time & Space Complexity:
# Time Complexity: O(n))
# Space Complexity: O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev, curr = None, slow
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        first, second = prev, head
        while first and second:
            if first.val != second.val:
                return False
            first = first.next
            second = second.next
        return True