package sort;

import java.util.Arrays;

/**
 * Created by Noahhhhha
 * on 2019/10/13 12:03.
 */
public class QuickSort {
    public static void main(String[] args) {
        // 给出无序数组
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        // 输出无序数组
        System.out.println(Arrays.toString(arr));
        // 快速排序 (对于调用者来说，越方便越好)
        quickSort(arr);
        // 输出有序数组
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        // 分区操作，也是具体连续比较的操作，返回分区界限索引
        if (start < end){ // 一直分治到一组只剩一个数，start == end 时 结束
            int index = partition(arr,start,end);
            // 对左分区进行排序
            quickSort(arr, start, index - 1);
            // 对右分区进行排序
            quickSort(arr, index + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // 指定左指针i和右指针j
        int i = start, j = end;
        // 将第一个数作为基准值。挖坑
        int x = arr[start];
        // 使用循环实现分区操作
        while (i < j){ // 当他们俩相等的时候，就都移动完了
            // 1、从右向左不停的移动j，直到找到第一个小于基准值的arr[j]
            while (i < j && arr[j] > x) j--;
            // 2、将右侧找到小于基准值的数加入到左边的（坑）位置，左指针向中间移动一个位置i++
            if (i < j){ // 如果等于的话，就没必要移动了
                arr[i] = arr[j]; // 此时j指向一个大于基准值的数，放置到i指向的坑中
                i++; // i本来指向挖掉的坑（基准值），此处从坑中跳出
            }
            // 3、从左向右移动i，找到第一个大于基准值的arr[i]
            while (i < j && arr[i] < x) i++;
            // 4、将左侧找到大于基准值的数加入到右边的（坑）位置，右指针向中间移动一个位置j--
            if (i < j){
                arr[j] = arr[i];
                j--; // j从坑中跳出去
            }
        }
        // 使用基准值填坑，这就是基准值的最终位置，此时i == j；arr[j] = x;
        arr[i] = x;
        // 返回基准值的位置索引 i == j
        return i;
    }
}
