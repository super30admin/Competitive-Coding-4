# TC : O(n)
# SC : O(1)
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
        fast = head
        slow = head
        while fast.next != None and fast.next.next!=None:
            slow = slow.next
            fast = fast.next.next

        curr = self.reverse(slow.next)
        start = head
        while curr != None:
            if curr.val != start.val:
                return False
            curr = curr.next
            start = start.next

        return True        


    def reverse(self,head):
        prev = None
        curr = head

        while curr!=None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev 