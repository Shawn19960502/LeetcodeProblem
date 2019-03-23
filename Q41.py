class Solution:
    def firstMissingPositive(self, nums) -> int:
        nums.append(0)
        length = len(nums)
        for i in range(length):
            if nums[i] < 0 or nums[i] >= length:
                nums[i] = 0
        for i in range(length):
            index = nums[i]
            nums[index % length] += length
        for i in range(1, length):
            if nums[i] / length == 0:
                return i
        return length

if __name__=='__main__':
    solution = Solution()
    solution.firstMissingPositive([2,2])