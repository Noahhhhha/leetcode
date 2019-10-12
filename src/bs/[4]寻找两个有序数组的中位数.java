package bs;//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length; // 长度
        int len2 = nums2.length;
        /**
         * 看到log(n+m)，基本肯定为二分法
         * 取中位数，设 k = (len1+len2)/2
         * 可以看作是取第k小的数
         * 二分法意图为每次去掉 k/2 个 数
         *
         * 排除奇偶数
         * 总长为3时， 2 ，2.5=2  奇数个，3取中间 为 2
         * 总长为4时， 2.5=2 ，3   偶数个，4取中间 为 2 3
         * 9   5  5.5  以 len1 = 1 , len2 = 8 举例
         */
        return (find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 1) / 2)
                + find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1)) * 0.5;
    }
    private int find(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int number) { // number 取第几个数的意思
        int len1 = end1 - start1 + 1; // 每次递归后长度都会因start指针变化而变化，要从新定义
        int len2 = end2 - start2 + 1;
        //确保nums1是短的
        if (len1 > len2) {
            return find(nums2, start2, end2, nums1, start1, end1, number);
        }
        //如果len1已经为空，直接从nums2找
        if (len1 == 0) {
            return nums2[start2 + number - 1];
        }
        //找第1个数，比较nums1[0]和nums2[0]谁更小即可
        if (number == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //因为nums1比较短，因此取位置时要考虑实际长度
        int pos1 = start1 + Math.min(number / 2, len1) - 1; // pos1 = 0 + Math.min(2,1) -1 = 0
        int pos2 = start2 + number / 2 - 1;                 // pos2 = 0 + 1 = 1
        if (nums1[pos1] > nums2[pos2]) { // nums1[0] > nums2[1]        pos2以前的数都会被舍弃
            return find(nums1, start1, end1, nums2, pos2 + 1, end2, number - number / 2);
        } else {
            return find(nums1, pos1 + 1, end1, nums2, start2, end2, number - Math.min(number / 2, len1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
