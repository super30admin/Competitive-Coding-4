class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None:
            return True
        if head.next is None:
            return True
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        # 1 - 2 -3- 2 - 1
        headTwo = self.reverse(slow)
        return self.checkPalindrome(head,headTwo)
    
    def reverse(self,head):
        p1 = None
        p2 = head
        while p2 is not None:
            p3 = p2.next
            p2.next = p1
            p1 = p2
            p2 = p3
        return p1

    def checkPalindrome(self,headOne,headTwo):
        p1 = headOne
        p2 = headTwo
        while p1 is not None and p2 is not None:
            if p1.val != p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        return True


l1 = ListNode(1)
l2 = ListNode(2)
l3 = ListNode(2)
l4 = ListNode(1)

print(Solution.isPalindrome(L))
