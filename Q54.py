class Solution:
    def __init__(self):
        pass
    def spiralOrder(self, matrix):
        row = len(matrix)
        if not row:
            return []
        column = len(matrix[0])
        if not column:
            return []
        dr = [0, 1, 0, -1]
        dc = [1, 0, -1, 0]
        r = c = 0
        di = 0
        res = []
        seen = [[False] * column for _ in range(row)]
        for _ in range(row * column):
            seen[r][c] = True
            res.append(matrix[r][c])
            cr = r + dr[di]
            cc = c + dc[di]
            if 0 <= cr < row and 0 <= cc < column and not seen[cr][cc]:
                r, c = cr, cc
            else:
                di = (di + 1) % 4
                r, c = r + dr[di], c + dc[di]
        return res

if __name__ == '__main__':
    so = Solution()
    so.spiralOrder([[1,2,3],[4,5,6],[7,8,9]])
