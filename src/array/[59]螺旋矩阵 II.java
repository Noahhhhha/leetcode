//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int index = 1, sum = n * n;
        while(index <= sum){ // 注意有等于号，因为是从1开始的，题目要求从1开始
            for(int i = left; i <= right; i++) res[top][i] = index++; // 一列一列的变
            top++; // 从左到右填充完毕，相当于上面少了一行
            for(int i = top; i <= bottom; i++) res[i][right] = index++; // 一行一行变
            right--;
            for(int i = right; i >= left; i--) res[bottom][i] = index++;
            bottom--;
            for(int i = bottom; i >= top; i--) res[i][left] = index++;
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
