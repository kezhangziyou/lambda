package lambda;



/**
 * lambda的性质2
 */
public class Property2 {
    /**
     lambda表达式的基本语法
     1)声明：就是和lambda表达式绑定的接口类型
     2)参数：包含在一对圆括号中，和绑定的接口中的抽象方法中的参数个数及顺序一致。
     3)操作符：->
     4)执行代码块：包含在一对大括号中，出现在操作符号的右侧
     [接口声明] = (参数) -> {执行代码块};
    */
    public static void main(String[] args) {

        /**
        1. lambda表达式，必须和接口进行绑定。
        2. lambda表达式的参数，可以附带0个到n个参数，括号中的参数类型可以不用指定，
           jvm在运行时，会自动根据绑定的抽象方法中电参数进行推导。
        3. lambda表达式的返回值，如果代码块只有一行，并且没有大括号，不用写return关键字，
           单行代码的执行结果，会自动返回。如果添加了大括号，或者有多行代码，必须通过return关键字返回执行结果。
         */
        //1、无参数lambda表达式
        ILambda1 i1 = () -> {
            System.out.println("hello zhangke!");
            System.out.println("welcome to zhangke!");
        };
        i1.test();
        //如果执行的代码只有一行，不用有花括号
        ILambda1 i2 = () -> System.out.println("hello zhangke");
        i2.test();

        //2、有参数，没有返回值lambda表达式
        ILambda2 i21 = (String n, int a) -> {
            System.out.println(n + "say: my year's old is " + a);
        };
        i21.test("jerry", 18);

        //3、省略参数类型，没有返回值，会根据绑定的接口的参数类型，做参数推断
        ILambda2 i22 = (n, a) -> {
            System.out.println(n + " 说：我今年" + a + "岁了.");
        };
        i22.test("tom", 22);

        //4、省略参数类型，有返回值，
        ILambda3 i3 = (x, y) -> {
            int z = x + y;
            return z;
        };
        System.out.println(i3.test(11, 22));

        //省略大括号，可以不用写return
        ILambda3 i31 = (x, y) -> x + y;
        System.out.println(i31.test(100, 200));



    }


}

/**
 * 没有参数，没有返回值的lambda表达式绑定的接口
 */
interface ILambda1 {
    void test();
}

/**
 * 带有参数，没有返回值的lambda表达式
 */
interface ILambda2 {
    void test(String name, int age);
}

/**
 * 带有参数，带有返回值的lambda表达式
 */
interface ILambda3 {
    int test(int x, int y);
}
