package com.hss.webflux.lambda;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/17 0017 18:45
 * Describe:
 */
public class LogDemo
{
    private static final Logger logger = Logger.getLogger(LogDemo.class.getName());

    @Override
    public String toString()
    {
        System.out.println("这个方法执行了, 耗时1秒钟");
        try
        {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e)
        {
        }

        return "LogDemo";
    }

    public void test()
    {
        // 如果不加判断直接打印, 会有额外多余的开销, 就算最终日志并没有打印
        logger.fine("打印一些日志:" + this);
        logger.fine(() -> "打印一些日志:" + this);
    }

    public static void main(String[] args)
    {
        LogDemo demo = new LogDemo();
        demo.test();
    }
}
