package com.hss.webflux.lambda;

import java.util.stream.IntStream;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/16 0016 14:52
 * Describe:
 */
public class MinDemo
{
    public static void main(String[] args) {
        int[] nums = {33,55,-55,90,-666,90};

        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if(i < min) {
                min = i;
            }
        }

        System.out.println(min);

        // jdk8
        int min2 = IntStream.of(nums).parallel().min().getAsInt();
        System.out.println(min2);
    }
}
