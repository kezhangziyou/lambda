package com.zhangke.service;

import com.zhangke.service.imp.MessageFormatImpl;
import com.zhangke.service.imp.UserCredentialImpl;

/**
 * Hello world!
 *
 * 需求改动：
 *  所有的用户验证，可以同时获取用户的验证信息[是否认证成功|成功~返回用户|null]
 *
 *  Lambda表达式 基本语法
 * @author 刘权
 */
public class ServiceTest {
    String welcome = "慕课网欢迎您.";
    public static void main( String[] args ) {
         //一、接口的静态方法和默认方法
        // 1. 默认方法
        IUserCredential ic = new UserCredentialImpl();
        System.out.println(ic.verifyUser("admin"));
        System.out.println(ic.getCredential("admin"));

        // 2. 类的静态方法
        String msg = "hello world";
        if (IMessageFormat.verifyMessage(msg)) {
            IMessageFormat format = new MessageFormatImpl();
            format.format(msg, "json");
        }

        // 3、匿名内部类，实现接口的抽象方法，比接口的实现更加简洁
        IUserCredential ic2 = new IUserCredential() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username)?"管理员":"会员";
            }
        };
        System.out.println(ic2.verifyUser("manager"));
        System.out.println(ic2.verifyUser("admin"));

        //4、lambda表达式 是 函数式接口的一种实现
        // lambda表达式，针对函数式接口的简单实现(ic2的lambda的实现)
        IUserCredential ic3 = (String username) -> {
            return "admin".equals(username)?"lbd管理员": "lbd会员";
        };
        System.out.println(ic3.verifyUser("manager"));
        System.out.println(ic3.verifyUser("admin"));


    }


}
