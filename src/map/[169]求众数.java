package map;//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

/**
 * HashMap 一层循环 效率没有两层循环的高
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int times = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            cur = map.get(nums[i]);
            if (cur > times){
                times = cur;
                max = nums[i];
            }
        }
        return max;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * HashMap 两层循环
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        int times = 0;
        int max = 0;
        for(int i : map.keySet()){
            times = Math.max(times,map.get(i));
            if(map.get(i) == times) max = i;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
