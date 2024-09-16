# Time Complexity : O(n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
    # 1) find out the middle using slow and fast 
    # 2) reverse the reamining list after middle(which is where slow is) by passing slow.next to the reverse function 
    # 3) get the new reversed linked list and place the slow(currently pointing to middle) at start, and start matching each element one by one.

class Node:
    def __init__(self,x):
        self.val = x 
        self.next = None 

class Solution:
    def isPalindrome(self,head):
        if not head:
            return True 
        slow = head 
        fast = head.next
        while fast and fast.next:
            fast = fast.next.next 
            slow = slow.next 
        newHead = self.__reverse(slow.next)
        slow.next = None 
        slow = head 
        while slow and newHead:
            if slow.val != newHead.val:
                return False 
            slow = slow.next 
            newHead = newHead.next 
        return True 

    def __reverse(self,head):
        prev = None 
        slow = head 
        fast = head.next 
        while fast:
            slow.next = prev 
            prev = slow 
            slow = fast 
            fast = fast.next 
        slow.next = prev 
        return slow 

if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.next = Node(2) 
    n.next.next = Node(3)
    n.next.next.next = Node(2)
    n.next.next.next.next = Node(1)
    res = s.isPalindrome(n)
    print(res)