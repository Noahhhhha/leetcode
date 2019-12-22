//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的最短时间。 
//
// 示例 1： 
//
// 
//输入: tasks = ["A","A","A","B","B","B"], n = 2
//输出: 8
//执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
// 
//
// 注： 
//
// 
// 任务的总个数为 [1, 10000]。 
// n 的取值范围为 [0, 100]。 
// 
// Related Topics 贪心算法 队列 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 方法一：排列
        int time = 0;
        int[] map = new int[26];

        for (char c : tasks)
            map[c - 'A'] ++;

        Arrays.sort(map);

        while (map[25] > 0) {
            int i = 0;
            while (i < n + 1) {
                // 我们以 n + 1 为一个周期
                if (map[25] == 0) break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i] --;
                time ++;
                i ++;
            }
            Arrays.sort(map); // 贪心策略，因为 n + 1 为一个周期，所以最后一个类型的任务，每次循环都是执行两次，所以贪心的先解决掉任务量最多的那个任务
        }

        return time;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 方法二：设计表格，答案见官方题解
        int[] map = new int[26];
        for (char c : tasks){
            map[c - 'A'] ++;
        }
        Arrays.sort(map);

        int row = map[25] - 1;
        int form = row * n;

        for (int i = 24; i >= 0 && map[i] > 0; i--){
            form -= Math.min(row, map[i]); // 考虑到多个类型的数量都是最大的
        }

        // 如果剩余时间还有，总时间就是原有的任务数加上位了n个冷却值补充的冷却时间
        // 如果没有剩余时间了，我们可以补充一些虚拟的列，即列数 > n,不影响规则，这样的话，直接回答tasks.length即可，注意题目要求。
        return form > 0 ? tasks.length + form : tasks.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
