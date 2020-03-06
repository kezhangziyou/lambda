package lambda;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: lambda App5
 * <p>TODO</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
public class Property6 {

    public static void main(String[] args) {
        Test t = (msg) -> System.out.println(msg);
        t.test("lambda!");
    }

    interface Test {
        void test(String msg);
    }

}




