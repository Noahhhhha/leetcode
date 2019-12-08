//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);

        Arrays.sort(intervals, (x, y) -> x[0] - y[0]); // 根据左区间排序，很重要
        for (int[] i : intervals){
            int last = res.size() - 1;
            if (res.isEmpty() || res.get(last)[1] < i[0]) // 如果区间没有相交，直接加到结果集中
                res.add(i);
            else
                res.get(last)[1] = Math.max(i[1], res.get(last)[1]); // 有相交的区间，就要比较两个的右区间
        }
        return res.toArray(new int [0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
