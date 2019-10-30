//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例: 
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int capable = 0, low = 0, fast = height.length - 1;
        // 双指针
        // 一个指针从头开始，一个指针从尾开始
        // 因为容器大小是取决于短板的那一侧，所以想寻求最优解，需要选择移动短板的那一侧指针去试探，再一一比较。
        while(low != fast){
            capable = Math.max(capable,(fast - low)*Math.min(height[low],height[fast]));
            if (height[low] < height[fast]) low++;
            else fast--;
        }
        return capable;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
