# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        #optimized
        #O(n) time and O(1) space
        if head is None or head.next is None:
            return True
        #find mid
        mid,fast = head,head
        
        while fast.next is not None and fast.next.next is not None:
            mid = mid.next
            fast = fast.next.next
        # reversing from mid
        
        prev = mid
        cur = mid.next
        fast = mid.next.next
        mid.next = None
        
        while fast is not None:
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        
        cur.next = prev
        # checking both half linked lists
        node = head
        while cur is not None and  node is not None:
            if cur.val != node.val:
                return False
            cur = cur.next
            node = node.next
        return True
        #brute force
        #O(n) time and O(n) space
#         cloneLi = []
#         node = head
#         while node is not None:
#             cloneLi.append(node.val)
#             node = node.next
        
#         return cloneLi[::-1] == cloneLi

        