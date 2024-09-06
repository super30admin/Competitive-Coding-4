# Competitive-Coding-4

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 



# Problem 1 - https://leetcode.com/problems/palindrome-linked-list/description/

In this approach we will be using two pointers slow and fast to find the middle of the linked list. As soon as fast pointer reaches end, slow pointer would be at exact middle of the linked list. Then we will reverse the second half of the list and we will then make slow pointer next to null and head2 as second half reverese list. Then we will compare one by one elements. If all corresponding nodes match, the list is palindrome otherwise it's not.



# Problem 2 - https://leetcode.com/problems/balanced-binary-tree/description/

Here in the function we are checking whether a binary tree is balanced by recursively comparing the heights of the left and right subtrees of each node. If the height difference between any two corresponding subtrees is greater than 1 then the tree is unbalanced. The isBalanced method is checking this condition for each node while in the height function we are simply computing the heights of the trees. 


