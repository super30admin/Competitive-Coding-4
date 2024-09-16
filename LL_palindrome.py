# O(N) TIME AND O(1) SPACE WHERE N IS LENGHT OF LL

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return True
        tailOne = self.getTail(head)
        headTwo = self.reverseSecondHalf(tailOne.next)
        p1 = head
        p2 = headTwo
        while p1 is not None and p2 is not None:
            if p1.val != p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        return True
    
    
    def getTail(self,head):
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        return slow

    def reverseSecondHalf(self,node):
        p1 = None
        p2 = node
        while p2 is not None:
            p3 = p2.next
            p2.next = p1
            p1 = p2
            p2 = p3
        return p1

        