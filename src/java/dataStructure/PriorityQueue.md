```
第一次看到是在630题课程表Ⅲ中
Java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示（任意一个非叶子节点的权值，都不大于其左右子节点的权值），也就意味着可以通过数组来作为PriorityQueue的底层实现。
```

```java
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 限制时间从小到大
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((a, b) -> b - a); // 花费时间从大到小
        int x = 0;
        for (int c[] : courses){
            if (c[0] + x <= c[1]){ // 对应步骤2
                pqueue.add(c[0]);
                x += c[0];
            }else if (!pqueue.isEmpty() && pqueue.peek() > c[0]){ // 对应步骤3
                x += c[0] - pqueue.poll();
                pqueue.add(c[0]);
            }
        }
        return pqueue.size();

    }
}
```
可以看出这个优先队列可以按照自己的想法排列队列中的顺序
>PriorityQueue类在Java1.5中引入并作为 Java Collections Framework 的一部分。PriorityQueue是基于优先堆的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。 
   优先队列不允许空值，而且不支持non-comparable（不可比较）的对象，比如用户自定义的类。优先队列要求使用Java Comparable和Comparator接口给对象排序，并且在排序时会按照优先级处理其中的元素。
   优先队列的头是基于自然排序或者Comparator排序的最小元素。如果有多个对象拥有同样的排序，那么就可能随机地取其中任意一个。当我们获取队列时，返回队列的头对象。
   优先队列的大小是不受限制的，但在创建时可以指定初始大小。当我们向优先队列增加元素的时候，队列大小会自动增加。
   PriorityQueue是非线程安全的，所以Java提供了PriorityBlockingQueue（实现BlockingQueue接口）用于Java多线程环境。

