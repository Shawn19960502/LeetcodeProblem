

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = - nums[i] - nums[j];
                if(map.containsKey(k) && map.get(k) > j) {
                    result.add(new LinkedList<>(Arrays.asList(nums[i], nums[j], k)));
                }
            }
        }
        return result;
    }
}
