# tc O(n), sc O(n).
if not root:
    return []

queue = deque([root])
largest_values = []

while queue:
    max_at_current_level = float('-inf')
    for _ in range(len(queue)):
        node = queue.popleft()
        max_at_current_level = max(max_at_current_level, node.val)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    largest_values.append(max_at_current_level)

return largest_values