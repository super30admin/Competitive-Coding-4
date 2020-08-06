"""
Problem:
https://leetcode.com/problems/palindrome-linked-list/

Approach: 

1. Find middle of the list
2. Reverse the list after teh middle node
3. compare the two lists

"""

# Time Complexity : O(n) where n is the no of nodes in the list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


class Solution:
    
    def reverse(self,node):
        prev = None
        cur = node
        while(cur!=None):
            temp = cur.next
            cur.next = prev
            prev= cur
            cur = temp
        return prev
    
    def isPalindrome(self, head: ListNode) -> bool:
        if(head==None):
            return True
        
        # find mid
        
        slow,fast = head,head
        
        while(fast.next!=None and fast.next.next!=None):
            slow = slow.next
            fast = fast.next.next
            
        #reverse (slow.next)
        headB = self.reverse(slow.next)
        
        headA = head
        
        ## comparision
        while(headB!=None):
            if(not headA.val == headB.val):
                return False
            headA= headA.next
            headB= headB.next
        
        return True

  