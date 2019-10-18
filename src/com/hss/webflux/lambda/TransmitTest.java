package com.hss.webflux.lambda;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/18 0018 10:09
 * Describe:
 */
public class TransmitTest
{
    public static void main(String[] args)
    {
        String a = "hello"; //String 引用数据类型，调用 pass 方法后 b 的值没有改变，还是 1
        int b = 1; //int 基本数据类型，调用 pass 方法后 a 的值没有改变，还是 1

        User user = new User(); //new Class 引用类型，调用 pass 方法后 name 与 age 的值改变了
        user.setName("main"); // 调用 pass 后，name 为 pass 了
        user.setAge(2); //调用 pass 后，age 为 4 了

        pass(user, a, b); //pass 方法调用

        System.out.println("main 方法 user 是：" + user.toString());
        System.out.println("main 方法 a 的值是：" + a + " --- b 的值是：" + b);
    }

    public static void pass(User user, String a, int b)
    {
        a = "你好";
        b = 3;

        user = new User();
        user.setName("pass");
        user.setAge(4);

        System.out.println("pass 方法 user 是：" + user.toString());
        System.out.println("pass 方法 a 的值是：" + a + " --- b 的值是：" + b);
    }
}


class User
{
    String name;
    int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "name = " + name + " --- age = " + age;
    }
}