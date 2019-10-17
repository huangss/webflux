package com.hss.webflux.lambda;

import java.util.function.Function;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/17 0017 15:11
 * Describe:
 */
public class CurryDemo
{
    public static void main(String[] args)
    {
        // 实现了x+y的级联表达式
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;
        System.out.println(fun.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> fun2 = x -> y -> z -> x + y + z;
        System.out.println(fun2.apply(2).apply(3).apply(4));

        int[] nums = {2, 3, 4};
        Function f = fun2;

        for (int i = 0; i < nums.length; i++)
        {
            if (f instanceof Function)
            {
                Object obj = f.apply(nums[i]);
                if (obj instanceof Function)
                {
                    f = (Function) obj;
                } else
                {
                    System.out.println("调用结束：结果为" + obj);
                }
            }
        }
    }
}
