package com.hss.webflux.stream;

import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Package: com.hss.webflux.stream
 * Author: Susie Huang
 * DateTime: 2019/10/21 0021 9:56
 * Describe: 收集器：
 */
class Student
{
    private String name;
    private int age;
    private Gender gender;
    private Grade grade;

    public Student()
    {

    }

    public Student(String name, int age, Gender gender, Grade grade)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

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

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Grade getGrade()
    {
        return grade;
    }

    public void setGrade(Grade grade)
    {
        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return "CollectorDemo{" +
                "[name=" + name + ", age=" + age + ", gender=" + gender
                + ", grade=" + grade + "]" +
                '}';
    }
}

/**
 * 性别
 */
enum Gender
{
    MALE, FEMALE
}

/**
 * 班级
 */
enum Grade
{
    ONE, TWO, THREE, FOUR;
}

public class CollectorDemo
{
    public static void main(String[] args)
    {
        List<Student> students = Arrays.asList(
                new Student("小明", 10, Gender.MALE, Grade.ONE),
                new Student("大明", 9, Gender.MALE, Grade.THREE),
                new Student("小白", 8, Gender.FEMALE, Grade.TWO),
                new Student("小黑", 13, Gender.FEMALE, Grade.FOUR),
                new Student("小红", 7, Gender.FEMALE, Grade.THREE),
                new Student("小黄", 13, Gender.MALE, Grade.ONE),
                new Student("小青", 13, Gender.FEMALE, Grade.THREE),
                new Student("小紫", 9, Gender.FEMALE, Grade.TWO),
                new Student("小王", 6, Gender.MALE, Grade.ONE),
                new Student("小李", 6, Gender.MALE, Grade.ONE),
                new Student("小马", 14, Gender.FEMALE, Grade.FOUR),
                new Student("小刘", 13, Gender.MALE, Grade.FOUR)
        );

        // 得到所有学生的年龄列表
        // 推荐使用方法引用Student::getAge，不要使用s->s.getAge(),就不会多生成一个类似 lambda$main$0这样的函数
        //List<Integer> ages = students.stream().map(s->s.getAge()).collect(Collectors.toList());
        List<Integer> ages = students.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println("所有学生的年龄:" + ages);

        //去重复
        Set<Integer> ages2 = students.stream().map(Student::getAge).collect(Collectors.toSet());
        System.out.println("去重复所有学生的年龄:" + ages2);

        //转换为指定类型的集合
        Set<Integer> ages3 = students.stream().map(Student::getAge).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("转换为指定类型的集合所有学生的年龄:" + ages3);

        //统计信息
        //IntSummaryStatistics{count=3, sum=39, min=12, average=13.000000, max=14}
        IntSummaryStatistics agesSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("年龄汇总信息:" + agesSummaryStatistics);

        //分块
        Map<Boolean, List<Student>> genders = students.stream().collect(Collectors.partitioningBy(s -> s.getGender() == Gender.MALE));
        MapUtils.verbosePrint(System.out, "男女学生分块列表", genders);

        //分组
        Map<Grade, List<Student>> grades = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        MapUtils.verbosePrint(System.out, "学生班级分组列表", grades);

        //列表分组统计，得到所有班级学生的个数
        Map<Integer, Long> gradesCount = students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        MapUtils.verbosePrint(System.out, "学生班级个数分组统计列表", gradesCount);
    }
}
