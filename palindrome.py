# Time Complexity: O(n)
# Space Complexity: O(1)
# The program ran successfully run on Leetcode
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False
        slow = head
        fast = head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        head2 = slow.next
        slow.next = None
        curr = head2
        prev = None

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        head2 = prev

        while head and head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True

