# Time complexity is O(n)
# Space complexity is O(1).

class Solution:
    def isPalindrome(self, head):
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        if fast:  # odd nodes: let right half smaller
            slow = slow.next
        slow = self.reverse(slow)
        fast = head

        while slow:
            if fast.val != slow.val:
                return False
            fast = fast.next
            slow = slow.next
        return True

    def reverse(self, head):
        prev = None
        while head:
            next_node = head.next
            head.next = prev
            prev = head
            head = next_node
        return prev
