#  Time Commplexity: O(n)
#  Space Complexity: O(1)
#  Did it work on leetcode: YES
#  Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        def reversed_list(head):
            prev = None
            curr = head

            while curr:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
            return prev

        slow = head
        fast = head

        while fast != None and fast.next != None:
            fast = fast.next.next
            slow = slow.next

        fast = head
        slow = reversed_list(slow)

        while slow!= None:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
        return True