# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
    class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # initializing pointers
        fast = slow = head
        # find the middle node
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        # reverse the second half
        node = None
        while slow:
            nxt = slow.next
            slow.next = node
            node = slow
            slow = nxt
        # compare the first and second half nodes
        while node: # while node and head:
            if node.val != head.val:
                return False
            node = node.next
            head = head.next
        return True

# Problem 2
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
          class Solution:
              def isBalanced(self, root: TreeNode) -> bool:
                  return self.helper(root) != -1

              def helper(self,root):
                  #Edge case
                  if not root:
                      return True
                  #Checking height on the left of root
                  left_depth = self.helper(root.left)
                  if left_depth ==-1:
                      return -1
                  #Checking height on the right of root
                  right_depth = self.helper(root.right)
                  if right_depth ==-1:
                      return -1
                  #Checking condition
                  if abs(left_depth-right_depth) <= 1:
                      return 1+max(left_depth,right_depth)  
                  else:
                      return -1
