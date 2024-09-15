#Time Complexity :o(n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        vals = []
        current_node = head
        while current_node is not None:
            vals.append(current_node.val)
            current_node = current_node.next
        return vals == vals[::-1]