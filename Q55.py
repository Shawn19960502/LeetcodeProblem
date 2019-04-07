class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        maxreachable = 0
        i = 0
        while i<=maxreachable:
            new = nums[i] + i
            maxreachable = new if new > maxreachable else maxreachable
            if maxreachable >= len(nums) - 1:
                return True
            i += 1
        return False