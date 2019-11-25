//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。 
//
// 示例 1: 
//
// 
//输入: 
//asteroids = [5, 10, -5]
//输出: [5, 10]
//解释: 
//10 和 -5 碰撞后只剩下 10。 5 和 10 永远不会发生碰撞。
// 
//
// 示例 2: 
//
// 
//输入: 
//asteroids = [8, -8]
//输出: []
//解释: 
//8 和 -8 碰撞后，两者都发生爆炸。
// 
//
// 示例 3: 
//
// 
//输入: 
//asteroids = [10, 2, -5]
//输出: [10]
//解释: 
//2 和 -5 发生碰撞后剩下 -5。10 和 -5 发生碰撞后剩下 10。
// 
//
// 示例 4: 
//
// 
//输入: 
//asteroids = [-2, -1, 1, 2]
//输出: [-2, -1, 1, 2]
//解释: 
//-2 和 -1 向左移动，而 1 和 2 向右移动。
//由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
// 
//
// 说明: 
//
// 
// 数组 asteroids 的长度不超过 10000。 
// 每一颗行星的大小都是非零整数，范围是 [-1000, 1000] 。 
// 
// Related Topics 栈



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // 只有两种情况需要发生碰撞，进行处理
        // 其他情况直接推进栈就可以了
        Stack<Integer> s = new Stack<>();
        // 1、异号相等,不为空
        // 2、异号，栈顶小于这个数，不为空
        // 针对于题意，此处的异号还应满足 栈顶向右，入栈数向左 才算异号
        for (int enter : asteroids){
            point:{
                while (!s.isEmpty() && enter < 0 && 0 < s.peek()){
                    if (s.peek() < -enter){
                        // 顶端星球炸碎，考虑enter会不会对后面的数有影响
                        s.pop();
                        continue;
                    }else if(s.peek() == -enter){
                        s.pop();
                    }
                    // 当两个星球都撞没了，或者进来的星球没栈顶星球强，就考虑下一个星球吧
                    break point;
                }
                s.push(enter);
            }
        }

        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; --i){
            res[i] = s.pop();
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
