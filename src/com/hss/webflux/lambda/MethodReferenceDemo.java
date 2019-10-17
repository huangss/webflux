package com.hss.webflux.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/17 0017 9:43
 * Describe:
 */
class Dog
{
    private String name = "哮天犬";
    private int food = 50;
    public int age=5;

    public Dog()
    {

    }

    public Dog(String name)
    {
        this.name = name;
    }

    public static void bak(Dog dog)
    {
        System.out.println(dog + "叫了");
    }

    public int eat(Dog this, int num)
    {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}

public class MethodReferenceDemo
{
    public static void main(String[] args)
    {
        //1.静态方法引用
        Consumer<Dog> consumer = Dog::bak;
        Dog dog = new Dog();
        consumer.accept(dog);

        //2.使用对象实例的方法引用
        //2.1 非静态，使用对象实例的方法引用
        /*Function<Integer, Integer> function = dog::eat;
        System.out.println("还剩下:" + function.apply(2) + "斤");*/

        //2.2 非静态，方法的输入和输出类型一致时，可改成一元函数接口
        /*UnaryOperator<Integer> function = dog::eat;
        System.out.println("还剩下:" + function.apply(2) + "斤");*/

        //2.3 非静态，方法的输入和输出类型一致时，可改成无参函数接口
        IntUnaryOperator function = dog::eat;
        System.out.println("还剩下:" + function.applyAsInt(2) + "斤");

        //dog置空，不影响下面的函数执行，因为java参数是传值
        dog = null;
        System.out.println("还剩下" + function.applyAsInt(2) + "斤");

        //3. 非静态，使用类名来方法引用
        Dog dog2 = new Dog();
        BiFunction<Dog, Integer, Integer> biFunction = Dog::eat;
        System.out.println("还剩下:" + biFunction.apply(dog2, 6) + "斤");

        //4. 非静态，无参构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象：" + supplier.get());

        //5. 非静态，有参构造函数的方法引用
        Function<String, Dog> stringDogFunction = Dog::new;
        System.out.println("创造了一个新的对象:" + stringDogFunction.apply("旺旺"));

        // 测试java变量是传值还是传引用
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        test(list); //[a, b] -> 传值
        System.err.println(list);

        Dog dog3 = new Dog("哒哒");
        test2(dog3);
        System.err.println(dog3.age);
    }

    private static void test(List<String> list)
    {
        list = null;
    }

    private static void test2(Dog dog)
    {
        dog.age = 100;
    }
}
