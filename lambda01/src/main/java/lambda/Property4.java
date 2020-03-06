package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: lambda App3
 * <p>lambda表达式类型检查</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
public class Property4 {

    public static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy("hello", new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        //匿名内部类的形式
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });
        //lambda的形式
        test((x, y) -> {
            y.add(x);
            return y;
            //类型检查错误
//            x.add(y);
//            return x;
        });

        /*
        (x,y)->{..} --> test(param) --> param==MyInterface --> lambda表达式-> MyInterface类型
        这个就是对于lambda表达式的类型检查，MyInterface接口就是lambda表达式的目标类型(target typing)

        (x,y)->{..} --> MyInterface.strategy(T r, R r)--> MyInterface<String, List> inter
            --> T==String R==List --> lambda--> (x, y) == strategy(T t , R r)--> x==T==String  y==R==List
            lambda表达式参数的类型检查
         */

    }
}

