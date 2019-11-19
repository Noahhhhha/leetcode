//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 双指针
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        for(;left < right; left++){
            while(((A[left] & 1) != 1) && left < right) left ++;
            while(((A[right] & 1) == 1) && left < right) right--;
            swap(left, right, A);
        }
        return A;
    }
    private void swap(int a, int b, int[] A){
        int tep = A[a];
        A[a] = A[b];
        A[b] = tep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
