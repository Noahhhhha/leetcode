//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
// hashmap法
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > 1) return true;
        }
        return false;
    }
}

// 暴力法
public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
        for (int j = 0; j < i; ++j) {
            if (nums[j] == nums[i]) return true;
        }
    }
    return false;
}

// 排序法
public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) {
        if (nums[i] == nums[i + 1]) return true;
    }
    return false;
}

// hashset
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }


//leetcode submit region end(Prohibit modification and deletion)
