package com.hss.webflux.lambda;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/16 0016 10:46
 * Describe:
 */
@FunctionalInterface
interface Interface1
{
    //只有这一个待实现的接口
    int doubleNum(int i);

    default int add(int x, int y)
    {
        return x + y;
    }

    static int sub(int x, int y)
    {
        return x - y;
    }
}

@FunctionalInterface
interface Interface2
{
    //只有这一个待实现的接口
    int doubleNum(int i);

    default int add(int x, int y)
    {
        return x + y;
    }
}

interface Interface3 extends Interface1, Interface2
{
    @Override
    default int add(int x, int y)
    {
        return Interface1.super.add(x, y);
    }
}

public class LambdaDemo1
{
    public static void main(String[] args)
    {
        Interface1 i1 = (i) -> i * 2; //实现了Interface1的对象实例
        Interface1 i2 = i -> i * 2; //这种是最常见的写法
        Interface1 i3 = (int i) -> i * 2;
        Interface1 i4 = (int i) -> {
            System.out.println("多行的写法");
            return i * 2;
        };
    }
}
