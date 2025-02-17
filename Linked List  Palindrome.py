#T.C : O(n)
#S.C - O(1)
# We could convert a linked list into array then the solution would have been easy but here we need 
# to find the solution in space complexity O(1) 
# So we first created 2 pointer first poiter slow will find mid beacuse slow we would increment in 1 step 
# fast will increment in 2 time slow so when we reach fast = null or next is null then we would  slow would be at mid
# now we would reverse the 2nd half 
# lastly logic for palindrome is 
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast = head 
        slow = head

        while fast and fast.next:
            fast = fast.next
            fast = fast.next
            slow = slow.next 

        # Reversing 2nd half 

        prev = None 
        while slow:
            temp= slow.next
            slow.next = prev 
            prev = slow
            slow= temp

        left = head
        right = prev
        
        #palindrome
        while right:
            if left.val !=right.val:
                return False
            left = left.next
            right = right.next 
        return True 
    

# Helper function to convert a list into a linked list
def createLinkedList(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next
    return head
# Example Usage:
sol = Solution()
head = createLinkedList([1, 2, 2])  # Convert list to linked list
print(sol.isPalindrome(head))  # Output: True