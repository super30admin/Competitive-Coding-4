# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverse(self, head):
        prev = None
        curr = head
        next = head.next
        while next:
            curr.next = prev
            prev = curr
            curr = next
            next = next.next
        curr.next = prev
        return curr

    def isPalindrome(self, head) -> bool:
        if not head.next:
            return head
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        reversed = self.reverse(slow.next)
        while reversed:
            if head.val != reversed.val:
                return False
            head = head.next
            reversed = reversed.next
        return True


check = ListNode(1)
check.next = ListNode(2)
check.next.next = ListNode(2)
check.next.next.next = ListNode(1)
print(Solution().isPalindrome(check))
