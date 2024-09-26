# https://leetcode.com/problems/palindrome-linked-list/submissions/
# Time Complexity: O(n)
# Space Complexity: O(1) 
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return True

        slow = head
        fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        head2 = slow.next
        slow.next = None

        head2 = self.reverse(head2)
        while head and head2:
            if head.val != head2.val:
                return False
            else:
                head = head.next
                head2 = head2.next
        return True

    def reverse(self, head: Optional[ListNode]):
        if head is None or head.next is None:
            return head

        curr = head
        prev = None

        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev
