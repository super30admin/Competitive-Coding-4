# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        ispal = True
        slow = head
        fast = head
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        fast = self.reorder(slow.next)
        slow.next = None
        slow = head
        while(fast!=None):
            if fast.val!=slow.val:
                ispal = False
                break
            fast = fast.next
            slow = slow.next
        return ispal



    def reorder(self,head):
        if head==None or head.next == None:
            return head
        reverse = self.reorder(head.next)
        head.next.next = head
        head.next = None
        return reverse




        
