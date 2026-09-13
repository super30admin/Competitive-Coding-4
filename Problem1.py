# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def isPalindrome(self, head):
        slow = head
        fast = head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        reverseHead = self.reverse(slow.next)
        slow.next = None
        slow = head
        fast = reverseHead

        while slow is not None and fast is not None:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next

        return True

    def reverse(self, node):
        prev = None
        curr = node

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev
