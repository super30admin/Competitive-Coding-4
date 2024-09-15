'''

Did it run on leetcode: yes
Time Complexity: 0(N)
Space Complexity: 0(1)

Algorithm:
- find the middle element
- reverse the right part from the middle
- check element by elemnt in left and right for palindrome check

'''


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        
        fast,slow = head,head
        
        while fast!=None and fast.next!=None:
            slow = slow.next
            fast = fast.next.next
        
        if fast!=None and fast.next==None:
            slow=slow.next    
            
        temp = slow
        slowHead = None
        
        while temp:
            temp1 = temp.next
            temp.next = slowHead
            slowHead = temp
            temp=temp1
    
        
        first,second = head,slowHead
        
        while first and second:
            if first.val==second.val:
                first = first.next
                second = second.next
            else:
                return False
        
        return True
