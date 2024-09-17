# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        if not (head):
            return True
        """
        :type head: ListNode
        :rtype: bool
        """
        mid = self.find_mid(head)
        prev = None
        if not (mid.next):  # input [1]
            head2 = mid.next
        else:
            head2 = self.recursive_reve(prev, mid.next)  # reversed 2nd half of string
        mid.next = None
        # compare both sublists and return false if any values don't match else return true.
        while head and head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True

    def find_mid(self, head):
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def recursive_reve(self, prev, curr):
        if not (curr.next):
            head = curr
            curr.next = prev
            return head
        elif curr.next:
            next_node = curr.next
            curr.next = prev
        # prev = curr
        # curr=curr.next
        # if above 2 are given the self.recursive_reve(prev,curr)
        return self.recursive_reve(curr, next_node)
