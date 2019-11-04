# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Accepted on Leetcode
# Time Complexity - O(N)
# Space complexity - O(1)
#Approach - Using three pointers slow, fast, and rev. Move fast in 2X spped and slow in 1X speed. When fast or fast.next reaches None, slow will be at middle.
#At the same time rev = slow and rev.next = rev, so that rev moves in reverse direction from the middle. Checking values of slow and rev will check if linst is palindrome

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        rev = None
        slow = fast = head
        while fast != None and fast.next != None:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next
        if fast != None:
            slow = slow.next
        while rev != None and slow != None:
			if rev.val == slow.val:
				slow = slow.next
				rev = rev.next
			else:
				return False
        return True