package com.hss.webflux.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Package: com.hss.webflux.stream
 * Author: Susie Huang
 * DateTime: 2019/10/18 0018 11:43
 * Describe: 中间操作
 */
public class StreamDemo3
{
    public static void main(String[] args)
    {
        String str = "my name is 007";

        //把每个单词的长度调用出来
        //Map:得到某个对象的属性。例如mapToInt(输入一个字符串得到它的长度)
        Stream.of(str.split(" ")).filter(s -> s.length() > 2).map(s -> s.length()).forEach(System.out::println);

        //flatMap 适合A元素下面有B属性，B属性是集合，最终得到所有A元素里面的所有B属性的集合
        // intStream/longStream 并不是Stream的子类，所以要进行装箱  boxed
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(i -> System.out.println((char) i.intValue()));

        //peek 用于debug，是个中间操作，与foreach不同，foreach是终止操作
        System.out.println("--------------peek------------");
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        //limit的使用
        new Random().ints().filter(i -> i > 100 && i < 1000).limit(10).forEach(System.out::println);
    }
}
