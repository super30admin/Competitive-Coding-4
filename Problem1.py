# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# finding midpoint of the linked list then reversing second half of the linked and then comparing
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head.next == None:
            return True
        slow = head
        fast = head
        
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        print(slow.val)
        node = slow.next
        
        p1 = None
        p2 = node
        p3 = node.next
        
        while p3 != None:
            p2.next = p1
            p1 = p2
            p2 = p3
            p3 = p3.next
        p2.next = p1
        # print(p1.val)
        # print(p2.next.val)
        node = head
        while p2 != None:
            if p2.val != node.val:
                return False
            p2 = p2.next
            node = node.next
        return True
        