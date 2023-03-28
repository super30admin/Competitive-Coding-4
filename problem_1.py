#  Time Complexity :O(n)
#  Space Complexity :O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next: 
          return True
        slow = head 
        fast = head
        while fast.next and fast.next.next : 
          slow = slow.next 
          fast = fast.next.next
        temp = slow.next
        slow.next = None
        fast = self.reverse(temp) 
        slow = head 
        while fast : 
          if slow.val != fast.val :
             return False
          fast = fast.next
          slow = slow.next
        return True

    def reverse(self, head):
        prev = None 
        curr = head
        while curr :  
          fast = curr.next
          curr.next = prev
          prev = curr  
          curr = fast
        return prev

       

        

        