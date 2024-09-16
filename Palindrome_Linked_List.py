# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Space:O(1)
#Time:O(n)
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:return True
        #Find length
        root = head
        def middle(root):
            slow=fast=root
            while(fast and fast.next):
                slow=slow.next
                fast=fast.next.next
            # middle = slow.next
            # slow.next = None
            return slow
        def reverse_list(root):
            prev=None
            while(root):
                temp = root.next
                root.next = prev
                prev = root
                root = temp
            return prev
        
        root_first = ans = root
        root_second = reverse_list(middle(root))
        print(root_first.val,root_second.val)
        while(root_first and root_second):
            print(root_first.val,root_second.val)
            # temp_first = root_first.next
            # temp_second = root_second.next
            # root_first.next = root_second
            # root_second.next = temp_first
            # root_first = temp_first
            # root_second = temp_second
            if root_second.val!=root_first.val:
                return False
            root_first = root_first.next
            root_second = root_second.next
        return True
        