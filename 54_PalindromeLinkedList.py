# accepted in leetcode(234)
# time - O(N), space O(1)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # edge case
        if head is None or head.next is None:return True
        # to find the mid element of linked list
        slow = head
        fast = head.next
        while(fast != None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        head2 = self.reverse(slow.next) # calling reverse function to reverse secong half of linked list
        slow.next = None
        slow = head

        # compare both sublists and return false if any values don't match else return true.
        while head and head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True
    # reversing a linked list
    def reverse(self,curr):
        prev = None
        nextPtr = curr.next
        while nextPtr:
            curr.next = prev
            prev = curr
            curr = nextPtr
            nextPtr = nextPtr.next
        curr.next = prev
        return curr