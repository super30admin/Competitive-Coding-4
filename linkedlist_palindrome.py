
#Time Complexity: O(N).
#Auxiliary Space: O(1)
#Did this code successfully run on Leetcode :Yes




# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverselist(self,head):
        if not head or not head.next:
            return head
        prev = None
        cur = head
        fast = head.next
        
        while(fast):
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        cur.next = prev
        
        return cur
        
        
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
       
    
        dummy = ListNode(-1)
        dummy.next = head
        slow = dummy
        fast = dummy
        
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
            
        p2 = self.reverselist(slow.next)
        slow.next = None
        p1 = head
        while(p2):
            if p1.val!=p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        return True
        
        
            