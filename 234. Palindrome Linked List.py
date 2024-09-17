# TC: O(n)
# SC: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow,fast,prev = head, head, None
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            
        while slow:
            temp = slow.next
            slow.next = prev 
            prev = slow
            slow = temp
        
        first_part = head
        sec_part = prev
        
        while first_part and sec_part:
            if first_part.val !=sec_part.val:
                return False
            first_part = first_part.next
            sec_part = sec_part.next
            
        return True
    