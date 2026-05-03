# https://leetcode.com/problems/palindrome-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head):
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        revList = self.reverseLL(slow.next)
        slow.next = None
        return self.checkIfSimilar(head, revList)

    def reverseLL(self, head):
        prev = None
        while head:
            nextNode = head.next
            head.next = prev
            prev = head
            head = nextNode
        return prev

    def checkIfSimilar(self, head1, head2):
        while head1 and head2:
            if head1.val != head2.val:
                return False
            head1 = head1.next
            head2 = head2.next
        return True
