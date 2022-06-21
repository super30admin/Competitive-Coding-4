# time complexity is o(n), where n is the size of the input
# space complexity is o(1).
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if(not head or head.next == None):
            return head
        
        slow = head
        fast = head
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
        curr = slow.next
        slow.next = None
        prev  = None
        fast = curr.next
        while(fast != None):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        slow = head
        flag = True
        while(curr != None):
            if(slow.val != curr.val):
                flag = False
                break
            slow = slow.next
            curr = curr.next
        return flag
            
            
#         s1 = ''
#         s2 = ''
#         prev = None
#         root1 =  head
#         root2 = head
#         while(root1):
#             s1 += str(root1.val)
#             root1 = root1.next
#         while(root2):
#             curr = root2
#             root2 = root2.next
#             curr.next = prev
#             prev = curr
#             # head = head.next
#         while(prev):
#             s2 += str(prev.val)
#             prev = prev.next
#         if(s1==s2):
#             return True
#         else:
#             return False
        