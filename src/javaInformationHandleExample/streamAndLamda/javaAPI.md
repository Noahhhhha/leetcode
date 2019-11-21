179最大数中
```java
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
```

630课程表中Arrays.sort()和Priority的构造函数也能直接传lamda
```java
Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 限制时间从小到大
PriorityQueue<Integer> pqueue = new PriorityQueue<>((a, b) -> b - a); // 花费时间从大到小
```