# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Find the middle element, reverse the second half of list and compare each element. 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reversedList(self, head):
        prev, curr = None, head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev


    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head.next:
            return True

        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        p1, p2 = head, self.reversedList(slow.next)
        slow.next = None

        while p1 and p2:
            if p1.val != p2.val:
                return False

            p1 = p1.next
            p2 = p2.next

        return True
        