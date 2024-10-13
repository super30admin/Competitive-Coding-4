'''
    Time Complexity: O(3n/2) = O(n)
    Space Complexity: O(1)
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        fast = slow.next
        slow.next = None

        prev = None

        while fast:
            temp = fast.next
            fast.next = prev
            prev = fast
            fast = temp
        
        fast = prev
        slow = head

        while slow and fast:
            if slow.val != fast.val:
                return False
            
            slow = slow.next
            fast = fast.next

        return True
            


        