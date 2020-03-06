package lambda;

import java.util.UUID;
import java.util.function.*;

/**
 * lambda的性质1
 */
public class Property1 {
    public static void main(String[] args) {


        // 一、JDK8中java.util.function提供了大量的函数式接口
        //Predicate 接收参数T对象，返回一个boolean类型结果
        Predicate<String> pre = (String username) -> {
            return "admin".equals(username);
        };
        System.out.println(pre.test("manager"));
        System.out.println(pre.test("admin"));

        //Consumer 接收参数T对象，没有返回值
        Consumer<String> con = (String message) -> {
            System.out.println("要发送的消息：" + message);
            System.out.println("消息发送完成");
        };
        con.accept("hello 慕课网的学员们..");
        con.accept("imooc lambda expression.");

        //Function 接收参数T对象，返回R对象
        Function<String, Integer> fun = (String gender) -> {
            return "male".equals(gender) ? 1 : 0;
        };
        System.out.println(fun.apply("male"));
        System.out.println(fun.apply("female"));

        //Supplier 不接受任何参数，直接通过get()获取指定类型的对象
        Supplier<String> sup = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());

        //UnaryOperator 接口参数T对象，执行业务处理后，返回更新后的T对象
        UnaryOperator<String> uo = (String img) -> {
            img += "[100x200]";
            return img;
        };

        System.out.println(uo.apply("原图--"));
        //BinaryOperator 接口接收两个T对象，执行业务处理后，返回一个T对象
        BinaryOperator<Integer> bo = (Integer i1, Integer i2) -> {
            return i1 > i2 ? i1 : i2;
        };

        System.out.println(bo.apply(12, 13));
    }


}
