class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the fixed pointer to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Step 2: Use two pointers for the rest of the array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // Skip duplicates for the left and right pointers
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } 
                else if (sum < 0) {
                    left++; // We need a larger sum, move left pointer right
                } 
                else {
                    right--; // We need a smaller sum, move right pointer left
                }
            }
        }
        
        return result;
    }
}