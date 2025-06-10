'''
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
'''

# // Time Complexity : O(n)
# // Space Complexity : O(1)
# # // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # we find mid
        # 2 pointers - slow at 0, fast at 1
        # inc slow by 1, fast by 2 until fast != none
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # we break the connection
        current_node = slow.next
        slow.next = None

        # we reverse the second list
        prev = None
        while current_node:
            temp = current_node.next
            current_node.next = prev
            prev = current_node
            current_node = temp

        # init head at both, keep checking until null
        # prev in head of list 2
        check_1, check_2 = head, prev
        while check_1 and check_2:
            if check_1.val != check_2.val:
                return False
            check_1, check_2 = check_1.next, check_2.next
        return True