# Approach: Brute force would be to store the node vals in a list and reverse and see if it is same
# O(N) Time and O(N) space

# Optimized Solution
# Time - O(N)
# Space - O(1) in place

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:

        #base checks (empty LL or 1 element LL)
        if head == None or head.next == None:
            return True

        mid_point = self.getMidPoint(head)

        # reverse LL from mid point.next
        head2 = self.reverseLL(mid_point.next)

        ptr1 = head
        ptr2 = head2
        isPalindrome = True

        while isPalindrome and ptr2 != None:

            if ptr1.val != ptr2.val:
                isPalindrome = False

            ptr1 = ptr1.next
            ptr2 = ptr2.next

        # reorder the LL back to original
        mid_point.next = self.reverseLL(head2)

        return isPalindrome


    def getMidPoint(self, head):

        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:

            slow = slow.next
            fast = fast.next.next

        return slow


    def reverseLL(self, head):

        prev = None
        current = head
        fast = current.next

        while fast != None:

            current.next =prev
            prev = current
            current = fast
            fast = fast.next

        current.next = prev
        return current

