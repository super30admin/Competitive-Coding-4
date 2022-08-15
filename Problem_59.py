# Time Complexity: O(n)
# Space Complexity: O(1)

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
        # Find mid point
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        
        #### Reverse second half i.e after mid point
        head_rev = slow.next
        prev = None
        curr = head_rev
        fast = head_rev.next
        while(fast):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        #### Now compare first half elements with second half
        a = head
        b = curr
        # print(a)
        # print(b)
        while(a and b):
            if(a.val!=b.val):
                return False
            a = a.next
            b = b.next
        return True