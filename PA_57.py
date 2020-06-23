#LC 234 - Palindrome Linked List
#Time Complexity - O(n)
#Space Complexity - O(1)
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
        if not head:
            return True
        
        def getReversed(head):
            prev = None
            fast = head.next
            while fast:
                head.next = prev
                prev = head
                head = fast
                fast = fast.next
            head.next = prev
            return head
        fast = head
        slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        tmp = getReversed(slow)
        tmp1 = head
        while tmp1 and tmp:
            if tmp.val != tmp1.val:
                return False
            tmp1 = tmp1.next
            tmp = tmp.next
        return True