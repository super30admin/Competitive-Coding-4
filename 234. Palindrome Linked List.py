#Space: O(n)
#Time: O(n)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        curr = head
        arr=list()
        if curr.next is None or curr is None:
            return True

        while curr is not None:
            arr.append(curr.val)
            curr= curr.next
        l= 0
        r= len(arr) -1
        while(l <= r ):
            if( arr[l] != arr[r]):
                return False
            l = l + 1
            r = r - 1
        return True
