""" Explanation: For the optimal approach, I took two pointers slow and fast. By moving the fast pointer
    twice as fast as the slow pointer, we can find the mid since that's where the two pointers will
    intersect. Once we have the middle, we can reverse the second half of the Linked List that will
    be on the right side of the half. Now after reversing the second half, the first half should be
    same as the second half of the Linked List for it to be palindrome. SO we compare the values and
    return true if it's true.
    Time Complexcity: O(n)
    Space Complexcity: O(1)
    All TC's passed on LC: Yes
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        # two pointer to find the middle
        slow = fast = head

        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next

        # reverse the second half
        prev, current = None, slow
        while (current):
            temp = current.next
            current.next = prev
            prev = current
            current = temp

        # comapre the two halves of the Linked list
        first, second = head, prev
        while(second):
            if (first.val != second.val):
                return False
            first, second = first.next, second.next
        
        return True

        