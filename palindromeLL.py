# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # Complexity: Time O(n), Space: O(1)
        # find mid
        if(head==None or head.next==None):
            return True
        
        slow =None
        fast = head
        # 1 # 2 #3 #4 #5
        #1 #2 #3 #4
        while(fast!=None and fast.next!=None):
            if(slow==None):
                slow = fast
            else:
                slow=slow.next
            
            fast = fast.next.next
        
        mid = slow
        
        # reverse LL from mid
        head2 = None
        def reverse(root):
            if(root==None or root.next==None):
                nonlocal head2
                head2 = root
                return
            reverse(root.next)
            root.next.next = root
            root.next = None
            return
        
        reverse(mid.next)
        while(head2!=None):
            if(head.val!=head2.val):
                return False
            
            head = head.next
            head2 = head2.next
        return True
