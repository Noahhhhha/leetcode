package famous;

/**
 * Created by Noahhhhha
 * on 2019/11/4 17:57.
 */
public class LCS {
    public static void main(String[] args) {
        /**
         * 参考文章链接：https://blog.csdn.net/weixin_40673608/article/details/84262695
         */
        String str1 = "AGCAT", str2 = "GACGT";
        System.out.println(compute(str1.toCharArray(), str2.toCharArray()));
    }

    public static int compute(char[] str1, char[] str2) {
        int len1 = str1.length;
        int len2 = str2.length;

        int[][] array = new int[len1 + 1][len2 + 1]; // 绘制一个表格 len1 * len2 , 表格右下角的值就为LCS的长度
            // 第一句 字符 匹配第二句 字符，如果两个相同，就将左上方的数加1
            // 不相等，值为 左方 或 上方 值大的那一个
        for (int i = 1; i <= len1; i++) { // 行为str1
            for (int j = 1; j <= len2; j++) { // 列为str2
                if (str1[i - 1] == str2[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else { // 当其不相等的时候，再往下循环的同时，我们要保证最长”公共子序列要建立在之前的最长公共子序列中，因为要追求最长。
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }

        System.out.println("the first String is: " + new String(str1));
        System.out.println("the second String is: " + new String(str2));
        String lcsSequence = "";

        /**
         * 得到数组之后，再反向遍历回去
         * 如果箭头是↖，则代表这个字符是LCS的一员，存下来后 i-- , j--
         * 如果箭头是←，则代表这个字符不是LCS的一员，i--
         * 如果箭头是↑ ，也代表这个字符不是LCS的一员，j--
         * 如此直到i = 0或者j = 0时停止，最后存下来的字符就是所有的LCS字符
         * 总结：顺着箭头指回去
         * 图片解释：https://img-blog.csdnimg.cn/20181120124505151.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDY3MzYwOA==,size_16,color_FFFFFF,t_70
         */
        int i = len1, j = len2;
        while (i > 0 && j > 0) {
            if (str1[i - 1] == str2[j - 1]) { // 相等的话，说明就是公共子序列，像二维数组图中所示，斜着指回去
                lcsSequence = str1[i - 1] + lcsSequence;
                i--;
                j--;
            } else if (array[i - 1][j] >= array[i][j - 1]) { // 上边的值大于左边的值，就往上走，反之，往左走
                i--;
            } else {
                j--;
            }
        }

        System.out.println("the longest common subsequence is: " + lcsSequence);
        return array[len1][len2];

    }
}
