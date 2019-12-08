```
[500键盘行]
List<String> l = new ArrayList<>();
    ...
l.toArray(new String[l.size()]); 
```
```java
    // 二维数组的转换 - 56题 - 合并区间
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
```