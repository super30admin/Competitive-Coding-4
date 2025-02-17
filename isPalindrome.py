# Time Complexity : O(N)
# Space Complexity : O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # check middle pointer
        # reverse from middle 
        # check the nodes with head and reversed part

        slow = head
        fast = head

        while fast and fast.next:
            fast = fast.next
            fast = fast.next
            slow = slow.next
        #  reverse 
        prev = None 
     
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
        
        left, right = head, prev

        while right:
            if(left.val != right.val):
                return False
            else:
                left = left.next
                right = right.next

        

        return True