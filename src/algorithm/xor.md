<!-- TOC -->

- [XOR的用途](#xor的用途)
    - [不用进位的加法](#不用进位的加法)
        - [知识点](#知识点)
        - [来源：leetcode-371. 两整数之和](#来源leetcode-371-两整数之和)
    - [交换变量](#交换变量)
        - [知识点](#知识点-1)
        - [来源：leetcode-448. 找到所有数组中消失的数字](#来源leetcode-448-找到所有数组中消失的数字)
    - [消除相同的数字](#消除相同的数字)
        - [知识点](#知识点-2)
        - [来源：leetcode-136. 只出现一次的数字、leetcode-268. 缺失数字](#来源leetcode-136-只出现一次的数字leetcode-268-缺失数字)

<!-- /TOC -->
# XOR的用途

## 不用进位的加法

### 知识点

```
a & b 是进位值
a ^ b 是当前值
```

### 来源：leetcode-371. 两整数之和

```java 
//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算
class Solution {
    public int getSum(int a, int b) {
        // 在二进制里，如果不考虑进位，异或 ^ 可以当作加减法
        // & 可以做为进位值，左移一位就可以当作真正的进位值
        while(b != 0){ // 当进位值为0的时候，就不需要再计算了
            int temp = (a & b) << 1; // 算出进位值
            a = a ^ b; // 算出每一位上的值
            b = temp;
        }
        return a;
    }
}
```

## 交换变量

### 知识点

```java
// 不用第三方变量就可以交换
// a ^ b = c , c ^ b = a , c ^ a = b
private void swap(int i, int j){
    i = i ^ j;
    j = i ^ j;
    i = i ^ j;
}
```

### 来源：leetcode-448. 找到所有数组中消失的数字

```java
//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 此题鸽巢原理，每只鸽子到自己该到的巢
        int size = nums.length;
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < size; i++){
            // 此处注意这个while，如果不是while，可能换过来的元素就有可能错过
            // nums[nums[i] - 1] 表示nums[i] 这个数真正相待的坑， 其坑中数 是不是 等于这个数
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        
        // 检查，如果不在自己该在的巢里，这巢里就不是正确的数，就是少的那个数
        for (int i = 0; i < size; i++){
            if (nums[i] != i + 1)
                res.add(i + 1);        
        }
        
        return res;
    }
    
    // 不用第三方变量就可以交换
    // a ^ b = c , c ^ b = a , c ^ a = b
    private void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
```

## 消除相同的数字

### 知识点
```
XOR满足结合律
任何数与0 做异或 得其本身
任何数与其本身 做异或 得0
```

### 来源：leetcode-136. 只出现一次的数字、leetcode-268. 缺失数字

```java
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表
class Solution {
    public int singleNumber(int[] nums) {
        // 经典位运算题
        // 1、数字转换成二进制，任何数和 0 XOR 都得其本身
        // 2、相同数字的二进制 XOR 得 0
        // 3、XOR满足交换律，即可以看作相同的数字放到一起XOR
        int res = 0;
        for(int i = 0; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }
}
```

```java
//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。 
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学
/**
 * 异或位运算
 */
class Solution {
    public int missingNumber(int[] nums) {
        // 这道题对时间复杂度有要求，为线性，所以不做排序了，除了hash表以外，还可以做位运算异或，异或满足交换律，所以最后剩下来的一定是单独的那一个数
        // 这道题还可以用高斯求和公式，减去nums中的数，剩下的就是missing
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
```
