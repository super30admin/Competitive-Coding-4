'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Use slow and fast pointer to reach the middle of the list. Once we reach the middle of the list reverse
the second half of the list. Now you have mirror's of each side of the list ie if its 1->2-2->1 we have 1->2 and 2<-1
we can check if its a palindrome, if its a palindrome then return False else True. Also return the list to the orignal
state.
'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverse(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head

        R = self.reverse(head.next)
        head.next.next = head
        head.next = None
        return R

    def isPalindrome(self, head: ListNode) -> bool:
        if head == None:
            return True

        fast = head
        slow = head

        while fast.next != None and fast.next.next != None:
            fast = fast.next.next
            slow = slow.next

        secondHalf = self.reverse(slow.next)

        # left for first half of list and right for second half of list
        left = head
        right = secondHalf

        # print(secondHalf)
        while right != None:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        # Restore list
        slow.next = self.reverse(secondHalf)

        return True
