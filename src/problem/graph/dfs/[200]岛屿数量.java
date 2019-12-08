//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        // 深度遍历，遍历的同时删除掉岛屿
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count ++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] grid){
        if (i > grid.length - 1 || j > grid[0].length - 1 || j < 0 || i < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
