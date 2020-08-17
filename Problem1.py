# Time Complexity : O(n), where n is the len of list.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:

        if head is None or head.next is None:
            return True

        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        head2 = slow.next
        slow.next = None
        prev = None
        nextnew = None
        curr = head2

        while curr != None:
            nextnew = curr.next
            curr.next = prev
            prev = curr
            curr = nextnew

        head2 = prev

        while head != None and head2 != None:
            if head.val == head2.val:
                head = head.next
                head2 = head2.next
            else:
                return False
        return True
