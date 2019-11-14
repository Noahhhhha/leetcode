//编写一个算法来判断一个数是不是“快乐数”。 
//
// 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。 
//
// 示例: 
//
// 输入: 19
//输出: true
//解释: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        class Solution {
            public boolean isHappy(int n) {
                // 数学知识；所有的数最后都会收敛到1或4或3，只有1是快乐数
                // 但是本题用正规解法
                // 一旦循环计算中出现了之前算到过的数，就是循环了
                Set<Integer> set = new HashSet<>();
                int m = 0;
                while(true){
                    while(n != 0){
                        m += Math.pow(n % 10, 2);
                        n /= 10;
                    }
                    if(m == 1) return true;
                    else if(set.contains(m)) return false;
                    else{
                        set.add(m);
                        n = m;
                        m = 0;
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
