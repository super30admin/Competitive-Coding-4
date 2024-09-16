#TC-O(n)
#SC-O(n)
#logic-find middle of ll, reverse second half and check if both the halves have same element
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # middle of the ll
        def reverse(head):
            if head is None:
                return 
            if head.next is None:
                return head
            prev = reverse(head.next)
            head.next.next = head
            head.next = None
            return prev
        dummy=ListNode()
        dummy.next = head
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        # slow is the middle now
        temp = slow.next
        slow.next = None
        secondhead = reverse(temp)
        head = dummy.next
        while head and secondhead:
            print(head.val,secondhead.val)
            if head.val != secondhead.val:
                return False
            head = head.next
            secondhead = secondhead.next
        return True
    
        
        
        