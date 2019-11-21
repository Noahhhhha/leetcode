//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        // 有一个固定指针k，k < low < fast
        // 不需要 k在中间，双指针向中间凑，不需要！
        for(int k = 0; k < nums.length - 2; k++){
            if (nums[k] > 0) break;
            // 避免重复结果，比如排完序之后[-4,-1,-1,0,1,2]
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int l = k + 1, f = nums.length - 1;
            while(l < f){
                int number = nums[l] + nums[f] + nums[k];
                if (number > 0)
                    // 避免了重复结果
                    while(l < f && nums[f] == nums[--f]);
                else if (number < 0)
                    while(l < f && nums[l] == nums[++l]);
                else{
                    list.add(new ArrayList(Arrays.asList(nums[k],nums[l],nums[f])));
                    while(l < f && nums[f] == nums[--f]);
                    while(l < f && nums[l] == nums[++l]);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
