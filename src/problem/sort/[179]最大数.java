//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        /**
         * 这道题要点在于怎么判断谁放在前面好
         * 并且要注意，比较具有传递性 a > b, b > c, 则 a > c
         */
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums)
                .boxed() // 将intStream转换为Stream
                .map(x -> x.toString())
                .sorted((a, b) -> (b + a).compareTo(a + b))  // 基于字典顺序排列(unicode编码)
                .forEach(x -> sb.append(x));
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
