# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None or head.next == None:
            return True
        fp = head
        sp = head
        while fp and fp.next:
            sp = sp.next
            fp = fp.next.next

        curr = sp
        prev = None
        fast = curr.next
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        first_half = head
        second_half = curr
        while second_half:  # Only need to check the second half
            if first_half.val != second_half.val:
                return False
            first_half = first_half.next
            second_half = second_half.next

        return True
    
