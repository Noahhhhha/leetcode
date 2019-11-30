//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 遇到这种一串数组求最优解问题，第一步记住要排序
        // 滑动窗口题，说到底就是循环加剪枝
        // 一左一右固定两个点，然后两个指针在中间跳
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int l = nums.length;
        if (nums == null || l < 4) return list;

        for (int i = 0; i < l - 3; i++){
            // 记住i点是四个点中最小的点
            if (nums[i] * 4 > target) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 第二个定点
            for (int j = l - 1; j > i + 2; j--){ // 右点最少要跟左点差两个
                // 记住j是四个点中最大的点
                if (nums[j] * 4 < target) break;
                // 去重
                if (j < l - 1 && nums[j] == nums[j + 1]) continue;
                int left = i + 1, right = j - 1;
                while(left < right){
                    int result = nums[i] + nums[j] + nums[left] + nums[right];
                    if (result == target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left ++;
                        right --;
                        while (left < l - 2 && nums[left] == nums[left - 1]) left ++;
                        while (right > 2 && nums[right] == nums[right + 1]) right --;
                    }
                    else if (result < target){
                        left ++;
                        while (left < l -2 && nums[left] == nums[left - 1]) left ++; // 去重
                    }else {
                        right --;
                        while (right > 2 && nums[right] == nums[right + 1]) right --;
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
