package com.hss.webflux.lambda;

import java.text.DecimalFormat;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/16 0016 15:44
 * Describe:
 */
class MyMoney
{
    private final int money;

    public MyMoney(int money)
    {
        this.money = money;
    }

    public void getMoney(Function<Integer, String> moneyFormat)
    {
        System.out.println("我的存款是:" + moneyFormat.apply(this.money));
    }
}

public class MoneyDemo
{
    public static void main(String[] args)
    {
        /************ 函数式编程接口的使用 ************/
        //1. 函数接口Function<T,R>
        MyMoney me = new MyMoney(99999999);
        me.getMoney(i -> new DecimalFormat("#,###").format(i));
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i); //实现了输入是Integer，输出是String的接口对象实例
        me.getMoney(moneyFormat.andThen(s -> "人民币" + s));

        //2. 断言接口Predicate<T> 建议使用带类型的接口，这样就不用写泛型了IntConsumer
        IntPredicate predicate = i -> i > 0;
        System.out.println(predicate.test(-1));

        //3. 消费者接口Consumer<T>
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("输入的数据");
    }
}
