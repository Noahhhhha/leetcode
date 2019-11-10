//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for (int i = 1; i < numRows; i++){
            List<Integer> preRows = list.get(i - 1);
            List<Integer> curRows = new ArrayList<Integer>();
            curRows.add(1);
            for (int j = 1; j < i; j++){
                curRows.add(preRows.get(j - 1)+ preRows.get(j));
            }
            curRows.add(1);
            list.add(curRows);
        }
        return list;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
