package lambda;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: lambda App4
 * <p>方法重载对于lmabda表达式的影响</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
public class Property5 {

    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

    // 定义重载的方法
    public void lambdaMethod(Param1 param) {
        param.outInfo("hello param1 zhangke!");
    }
    public void lambdaMethod(Param2 param) {
        param.outInfo("hello param2 zhangke");
    }

       /**
        lambda表达式存在类型检查-> 自动推导lambda表达式的目标类型
        lambdaMethod() -> 方法 -> 重载方法
                -> Param1  函数式接口
                -> Param2  函数式接口
                调用方法-> 传递Lambda表达式-> 自动推导->
                    -> Param1 | Param2
         */
       public static void main(String[] args) {
        Property5 app = new Property5();

        app.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println("------");
                System.out.println(info);
            }
        });
        //有重载方法，会参数类型推断出两个
        //app.lambdaMethod( (String info) -> {
        //    System.out.println(info);
        //});



    }
}
