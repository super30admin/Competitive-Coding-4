# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
'''
Time Complexity -->
O(n)

Space complexity -->

O(1)
'''
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        if slow.next==None:
            return True
        if slow.next.next==None:
            if slow.val == slow.next.val:
                return True
            else:
                return False
        
        middle = None
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        middle = slow
        #print(middle.val)
        middle.next = self.reverseList(middle)
        #print(middle.next.val)
        
        curr2 = middle.next
        curr1 = head
        while curr2:
            if curr1.val !=curr2.val:
                return False
            curr1 = curr1.next
            curr2 = curr2.next
        return True
    
    def reverseList(self, node):
        prev = None
        curr = node.next
        nextNode = node.next.next
        #print(nextNode.val)
        while nextNode:
            curr.next = prev
            prev = curr
            curr = nextNode
            nextNode = nextNode.next
        curr.next = prev
        prev = curr
        #print(prev.val)
        return prev
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
            
        