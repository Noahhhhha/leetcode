//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？ 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序



//leetcode submit region begin(Prohibit modification and deletion)

/**
 * DAG!
 */
// 参考链接：https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
//使用递归
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 这个邻接表设定，初始赋值以后，就一直没有动过，只有flags在动。
        int[][] graph = new int[numCourses][numCourses];
        // cp[1] -> cp[0] ，横轴是前驱，纵轴是后继
        for (int[] cp : prerequisites) graph[cp[1]][cp[0]] = 1;
        // flags标志这个点有没有被访问过 0 - 没有被访问过，1，-1 - 刚递归到这个点的时候设置成1，
        // 这层递归结束的时候再改成-1，如果其子递归遇到已经是1的点，则证明成环了
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++){ // 每一个点都要接受递归，说不定有的点独立？
            if(!dfs(graph, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] flags, int i){
        if (flags[i] == 1) return false;
        // -1 说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (int j = 0; j < graph.length; j++){
            // 将i点指向的点再次递归
            if (graph[i][j] == 1 && !dfs(graph, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }
}


// 使用队列bfs，相对简单
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 此题的精髓在于看入度问题，和DAG有向无环图，若无环，则true
         * 根据给的表，新建一个数组，数组下标作为点，数代表有几个入度
         * 如果入度为0加入队列，类似于广度遍历，如果每个点都能在队列中走一遍，则证明没有成环
         */
        int[] courseDegree = new int[numCourses]; // 数组记录每个点的入度，下标代表每个点
        for (int[] cp : prerequisites) courseDegree[cp[0]]++; // cp[0] 是 [1,0] 中的1
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (courseDegree[i] == 0) queue.add(i);
        while(!queue.isEmpty()){
            // 取出队列中那些入度为0的点，把 cp[1] 为这些点的 cp[0]都减1，相等于度-1
            int first = queue.poll();
            numCourses--;
            for (int[] cp : prerequisites){
                if (cp[1] == first)
                    if (--courseDegree[cp[0]] == 0) queue.add(cp[0]);
            }
        }
        return numCourses == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
