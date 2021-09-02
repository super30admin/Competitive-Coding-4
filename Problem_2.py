# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    TC - O(n)
    SC - O(1)
    """
    def reverse(self, head, prev):
        if head == None:
            return prev
        temp = head.next
        head.next = prev
        return self.reverse(temp, head)

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None:
            return True
        start, end = head, head
        while end.next != None and end.next.next != None:
            start = start.next
            end = end.next.next
        start.next = self.reverse(start.next, None)
        while start.next != None:
            if start.next.val != head.val:
                return False
            start = start.next
            head = head.next
        return True