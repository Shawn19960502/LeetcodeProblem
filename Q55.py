class Solution:
    def canJump(self, nums) -> bool:
        if not nums:
            return False
        memo = [False for _ in nums]
        memo[-1] = True
        for index in range(len(nums) - 2, -1, -1):
            for i in range(nums[index]):
                index_p = i +  1 + index
                if index_p >= len(nums):
                    break
                elif memo[index_p]:
                    memo[index] = True
                    break
        return memo[0]

if __name__ == '__main__':
    so = Solution()
    so.canJump([2,3,1,1,4])