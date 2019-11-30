//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         * 当前点如果为1，当前点所在的dp值
         * 取决与左上角，上面，左面三个点的dp值
         */
        int row = matrix.length + 1, col = row > 1 ? matrix[0].length + 1: 1;
        int[][] dp = new int[row][col];
        int maxSquare = 0;
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),dp[i][j - 1]) + 1;
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

