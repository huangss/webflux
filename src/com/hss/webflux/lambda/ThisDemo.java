package com.hss.webflux.lambda;

/**
 * Package: com.hss.webflux.lambda
 * Author: Susie Huang
 * DateTime: 2019/10/17 0017 15:54
 * Describe:
 */
public class ThisDemo
{
    private String name = "ThisDemo";

    public void test()
    {
        //匿名类实现
        new Thread(new Runnable()
        {
            private String name = "Runnable";

            @Override
            public void run()
            {
                System.out.println("这里的this指向匿名类:" + this.name);
            }
        }).start();

        //lambda实现
        // 下面会自动生成lambda$0方法,由于使用了this,所以是非static方法
        new Thread(() -> System.out.println("这里的this指向当前的ThisDemo类:" + this.name)).start();

        // 下面会自动生成lambda$1方法,由于未使用this,所以是static方法
        new Thread(() -> System.out.println("这里没有引用this,生成的lambda1方法是static的")).start();
    }

    public static void main(String[] args)
    {
        ThisDemo demo = new ThisDemo();
        demo.test();
    }
}
