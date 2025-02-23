# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time O(n)
# Space O(1)
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]: # 2
        curr = head
        prev = None
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev


    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head
        # Find middle using slow
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        temp = slow.next
        slow.next = None
        fast = self.reverseList(temp) 

        # Reset slow
        slow = head
        while fast != None:
            if slow.val == fast.val: 
                fast = fast.next
                slow = slow.next
            else:
                return False
        return True

# Time O(n/2)
# Space O(n/2)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        arr = [head.val]
        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            arr.append(slow.val)
            slow = slow.next
            fast = fast.next.next
        # If even length list add slow val as it does not have pivot
        # For odd length we dont need to as it has pivot  
        if fast.next != None and fast.next.next == None:
             arr.append(slow.val)
        slow = slow.next
        while slow != None:
            val = arr.pop()
            if val != slow.val:
                return False
            slow = slow.next
        return True