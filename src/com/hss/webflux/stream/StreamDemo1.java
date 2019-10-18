package com.hss.webflux.stream;

import java.util.stream.IntStream;

/**
 * Package: com.hss.webflux.stream
 * Author: Susie Huang
 * DateTime: 2019/10/18 0018 10:48
 * Describe: 流编程
 */
public class StreamDemo1
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        // 外部迭代
        int sum = 0;
        for (int i : nums)
        {
            sum += i;
        }
        System.out.println("结果为：" + sum);

        // 使用stream的内部迭代
        System.out.println("结果为：" + IntStream.of(nums).sum());

        // map就是中间操作（返回stream的操作）
        // sum就是终止操作
        int sum2 = IntStream.of(nums).map(i -> i * 2).sum();
        System.out.println("结果为：" + sum2);

        System.out.println("惰性求值就是终止没有调用的情况下，中间操作不会执行");
        IntStream.of(nums).map(StreamDemo1::doubleNum); //没有终止操作，map不会执行，所以不会执行doubleNum里的打印内容
    }

    public static int doubleNum(int i)
    {
        System.out.println("执行了乘以2");
        return i * 2;
    }
}
