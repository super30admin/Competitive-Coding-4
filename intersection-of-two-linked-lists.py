# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Time O(n)
# Space O(1)
class Solution:
    def getLength(self, head: ListNode):
        count = 0
        while head != None:
            count += 1
            head = head.next
        return count
   
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = self.getLength(headA)
        lenB = self.getLength(headB)

        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        
        while headA != None:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        
        return None