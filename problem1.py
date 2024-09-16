#check if linked list is palindorme
#time complexity: O(n) where n is number of nodes
#space complexity: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        #slow will be mid
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next 
        #reverse a linked list
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        
        #check if it a linked list
        left = head
        right = prev
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True
    