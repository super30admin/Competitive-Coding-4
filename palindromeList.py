# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head.next == None:
            return True
        result = True
        slow = head
        fast = head
        #finding the middle here
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next

        def reversedLinkList(head):
            
            dummy = None
            current = head
            fast = head.next
            while fast != None:
                current.next = dummy
                dummy = current
                current = fast
                fast = fast.next

            current.next = dummy
            return current

        fast = reversedLinkList(slow.next)
        slow.next = None
        #print(fast)
        #print(head)
        while fast != None and head !=None:
            if fast.val != head.val:
                result = False
            fast = fast.next
            head = head.next
        
        return result

#Time complexity O(n) and space complexity O(1)
#breaking the linked list at the middle and comparing it with the reversed past of remaining list

            
            