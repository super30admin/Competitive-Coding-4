# Time Complexity : O(n) because we are traversing the linked list once
# Space Complexity : O(n) because we create a new list to store the values of the linked list, can be done in O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We solve the problem by creating a list from the linked list and then comparing the list with its reverse. 
This can be done in O(1) space by using a slow and fast pointer to find the middle of the linked list and 
then reversing the second half of the linked list and then comparing the two halves.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None: return True

        nums = []
        node = head
        while node != None:
            nums.append(node.val)
            node = node.next
        
        print(nums)
        print(nums[::-1])

        return True if nums == nums[::-1] else False