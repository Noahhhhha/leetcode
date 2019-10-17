package test;

/**
 * Created by Noahhhhha
 * on 2019/10/17 22:07.
 */
public class test1 {
    public static void main(String[] args) {
        int n = 1234234;
        int k = n >> 2; // 右缩小
        System.out.println(k);

        System.out.println(new Integer(k).byteValue());
    }
}
