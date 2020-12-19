# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Approach: Recursive

# In this apporach we will use a low pointer that points to the head element. Then next nodes will be called recursively until the last node. Then the last node will be popped from the stack and compared against the element pointing low pointer. If we understand what we will basically do is the we will mainitain low pointer and the system then will maintain high pointer for us and we will then compare both of them recurssively and if at any point both them turns out to be unequal then we will return false

# Time complexity: O(n); n=no of nodes
# Space complexity: O(n); n=no of nodes
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        if head == None:
            return True
        self.low = head
        return self.helper(head)

    def helper(self, head):
        if head != None:
            if not self.helper(head.next):
                return False

            if (head.val != self.low.val):
                return False

            self.low = self.low.next
        return True
        
        