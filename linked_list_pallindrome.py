"""
Palindrome linked list
https://youtu.be/QlkBxHUR2OQ

https://leetcode.com/problems/palindrome-linked-list/description/

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to first use slow,fast pointer and find the mid point and reverse the second half and then run a loop to iterate
if first half and second half are same or not. Now revert the reversal of second half and return the result.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head:
            return True

        end_of_first_half = self.find_end_of_first_half(head)
        second_half = end_of_first_half.next
        second_half = self.reverse(second_half)
        first_list = head
        second_list = second_half
        result = True
        while second_list is not None:
            if first_list.val != second_list.val:
                result = False
                break
            first_list = first_list.next
            second_list = second_list.next 
        end_of_first_half.next = self.reverse(second_half)
        return result

    def find_end_of_first_half(self, head):
        slow, fast = head, head

        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        return slow
        
    def reverse(self, head):
        prev = None
        curr = head

        while curr is not None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        
        return prev