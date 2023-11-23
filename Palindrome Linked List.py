# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def seperateAndGetMiddle(self, head):
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        newHead = slow.next
        slow.next = None

        return newHead
    def invertAndGetHead(self, head):
        prev = None
        curr = head
        next = head.next
        while curr:
            next = curr.next
            curr.next = prev

            prev = curr
            curr = next
        newHead = prev

        return newHead
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True
        head1 = head
        head2 = self.invertAndGetHead(self.seperateAndGetMiddle(head1))

        while head1 and head2:
            if head1.val != head2.val:
                return False
            head1 = head1.next
            head2 = head2.next
        return True