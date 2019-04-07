class Solution:
    def trap(self, height) -> int:
        if not height or len(height) == 1 or len(height) == 2:
            return 0
        count = 0
        flag = height[0]
        fl_index = 0
        res = 0
        for index, item in enumerate(height):
            if index == 0:
                continue
            if item >= flag:
                temp = (index - fl_index - 1) * min(item, flag)
                res += temp - count
                fl_index = index
                flag = item
            else:
                count += item
        if fl_index < len(height) - 2:
            res_temp = self.trap(height[fl_index + 1:])
            res = res + res_temp
        return res

if __name__=='__main__':
    so = Solution()
    print(so.trap([4,2,3]))

