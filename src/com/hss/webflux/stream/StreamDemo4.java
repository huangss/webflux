package com.hss.webflux.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Package: com.hss.webflux.stream
 * Author: Susie Huang
 * DateTime: 2019/10/18 0018 16:13
 * Describe: 终止操作
 */
public class StreamDemo4
{
    public static void main(String[] args)
    {
        String str = "my name is 007";

        //使用并行流
        str.chars().parallel().forEach(i -> System.out.print((char) i));
        System.out.println();
        // 使用 forEachOrdered 保证顺序
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
        System.out.println();

        //收集到list/set   set时最后使用toSet方法
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);

        //使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        //返回值为空时不报错
        System.out.println(letters.orElse(""));
        //带初始值的reduce
        String reduce = Stream.of(str.split(" ")).reduce("hi", (s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce);

        //计算所有单词总长度
        Integer length = Stream.of(str.split(" ")).map(s -> s.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);

        //使用max函数,长度最长的单词
        Optional<String> max = Stream.of(str.split(" ")).max(Comparator.comparingInt(String::length));
        System.out.println(max.get());

        //使用 findFirst 短路操作
        OptionalInt findFirst = new Random().ints().filter(i -> i > 10000).findFirst();
        System.out.println(findFirst.getAsInt());
    }
}
