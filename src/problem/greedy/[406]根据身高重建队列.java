//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 贪心策略：个子最高的，要求最小的
        // 先按个子大小把高个子的排好，再放置矮个子，矮个子直接放到矮个子想放的地方就行，不需要理会已经放好的大个子
        // 这里注意到了LinkedList源码有点与印象中不太一样，可以注意一下
        // http://www.51gjie.com/java/310.html

        // 先按身高从大到小排列，身高相同，就按位置从小到大
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[people.length][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
