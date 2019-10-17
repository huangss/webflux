package com.hss.webflux.lambda;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/16 0016 14:55
 * Describe:
 */
public class ThreadDemo
{
    public static void main(String[] args)
    {
        Object target = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("hello");
            }
        };
        new Thread((Runnable) target).start();


        //jdk8 lambda
        Object target2 = (Runnable) () -> System.out.println("shasha");

        Runnable target3 = () -> System.out.println("shasha"); //false
        System.out.println(target2 == target3);

        new Thread((Runnable) target2).start();
    }
}
