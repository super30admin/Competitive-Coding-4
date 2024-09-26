'''
Executed in leetcode: Yes, submitted successfully
Space complexity: O(1)
Time complexity: O(n)
Challenges: Did not figure out the recursive approach. Tried with Floyds algorithm.

Comments: Use recursive function to check the first set of elements with the last set of elements. As we reverse the list, check
if the element is equal to head. Then, update head to head.next and check it with the second last element, and so on.
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # Sanity check
        if not head or not head.next:
            return True
        
        self.head_val = head
        
        return self.recursive(head)
    
    def recursive(self,cursor):
        
        if cursor is not None:
            if not self.recursive(cursor.next):
                return False
            if self.head_val.val != cursor.val:
                return False
            self.head_val = self.head_val.next
        return True
