#234. Palindrome Linked List
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head): #T.C->O(N/2)
        """
        :type head: ListNode
        :rtype: bool
        """
        slow = head
        fast = head

        while fast!=None and fast.next!=None:
            slow = slow.next
            fast = fast.next.next
        fast = self.rev(slow)
        slow.next = None
        slow = head

        while slow!=None and fast!=None:
            if slow.val!=fast.val:
                return False
            slow = slow.next
            fast = fast.next
        return True
    def rev(self,head):
        prev = None
        curr = head

        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev