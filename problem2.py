# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


TC:O(n)
SC:O(1)

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False

        l1 = head
        l2 = self.reverse(head)

        while l1 is not None and l2 is not None:
            if l1.val != l2.val:
                return False
            else:
                l1 = l1.next
                l2 = l2.next

        return True



    def reverse(self,head):
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        l2 = slow.next
        slow.next = None

        curr = l2
        prev = None

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        return prev


