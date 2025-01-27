# tc O(1), sc O(1).
ROWS, COLUMNS = len(board), len(board[0])
rowsseen = defaultdict(set)
colsseen = defaultdict(set)
gridsseen = defaultdict(set)

for r in range(ROWS):
    for c in range(COLUMNS):
        num = board[r][c]
        if board[r][c] == ".":
            continue
        
        mygridr, mygridc = r // 3, c // 3
        if num in rowsseen[r] or num in colsseen[c] or num in gridsseen[(mygridr, mygridc)]:
            return False
        
        rowsseen[r].add(num)
        colsseen[c].add(num)
        gridsseen[(mygridr, mygridc)].add(num)

return True