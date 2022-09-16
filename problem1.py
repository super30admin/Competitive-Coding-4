'''
234. Palindrome Linked List

APPROACH 1: Stack
TIME COMPLEXITY: O(N)
SPACE COMPELXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: Nope

APPROACH 2: two pointers and reverse
TIME COMPLEXITY: O(N)
SPACE COMPELXITY: O(1)
LEETCODE: Yes
DIFFICULTIES: Nope
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from collections import deque

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # using stack
        def approach1(head):
            ls = []
            if head == None:
                return False
            if head.next == None:
                return True

            slow = head
            fast = head.next

            while fast != None and fast.next != None:
                slow = slow.next
                fast = fast.next.next

            slow = slow.next

            while slow != None:
                ls.append(slow.val)
                slow = slow.next

            tmp = head

            for i in range(len(ls)-1, -1, -1):
                if ls[i] != tmp.val:
                    return False
                tmp = tmp.next

            return True
        
        # using two pointers and reverse
        def approach2(head):
            
            if head == None:
                return False
            if head.next == None:
                return True

            
            fast = head
            slow = head
            tmp = slow
            
            def reverse(ptr):
                tmp = None
                ptr1 = ptr
                ptr2 = ptr.next
                
                while ptr2 != None:
                    ptr1.next = tmp
                    tmp = ptr1
                    ptr1 = ptr2
                    ptr2 = ptr2.next
                
                ptr1.next = tmp
                return ptr1
            
            while fast.next != None and fast.next.next != None:
                slow = slow.next
                fast = fast.next.next
            
            ptr1 = reverse(slow.next)
            slow.next = None
            ptr2 = tmp
            
            while(ptr1 != None and ptr2!=None):
                if ptr1.val != ptr2.val:
                    return False
                ptr1 = ptr1.next
                ptr2 = ptr2.next
            
            return True
    
        
        # return approach1(head)
        return approach2(head)
        
