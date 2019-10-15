//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

/**
 * 最优算法，从后向前双指针，相较于从前往后，省去了要O(m)的空间复杂度
 * 类似于链表合并的思想
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int pointer = nums1.length -1;

        while ((p >= 0) && (q >= 0)){
            nums1[pointer--] = nums1[p] > nums2[q] ? nums1[p--] : nums2[q--];
        }

        System.arraycopy(nums2, 0, nums1, 0, q+1);
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1. 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m) 的空间复杂度。
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2   
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 时间复杂度 : O((n + m)log(n + m))
         * 空间复杂度 : O(1)
         */
        // System.arraycopy(nums2, 0, nums1, m, n); java提供的合并数组方法
        for (int i = m; i < (m + n); i++){
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
