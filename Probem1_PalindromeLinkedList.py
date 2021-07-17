# Time Complexity: O(n), where n is the number of nodes in the list
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True

        # Find the middle element
        slow = ListNode(-1)
        slow.next = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Split into 2 lists and reverse the second half
        head2 = self.reverse(slow.next)
        slow.next = None

        # Compare the 2 lists
        while head and head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next

        return True

    def reverse(self, head: ListNode) -> ListNode:
        if not head:
            return None
        prev = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

