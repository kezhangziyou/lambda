package com.zhangke.service;

/**
 * 用户身份认证标记接口
 */
@FunctionalInterface//表示该接口为函数式接口(只包含一个方法的接口)
public interface IUserCredential {

    /**
     * 通过用户账号，验证用户身份信息的接口
     * @param username 要验证的用户账号
     * @return 返回身份信息[系统管理员、用户管理员、普通用户]
     */
    String verifyUser(String username);


    /**
     * 默认接口方法
     * jdk1.8以后再接口中可以定义默认方法和静态方法
     * @param username 要验证的用户账号
     * @return
     */
    default String getCredential(String username) {
        // 模拟方法
        if ("admin".equals(username)) {
            return "admin + 系统管理员用户";
        } else if("manager".equals(username)){
            return "manager + 用户管理员用户";
        } else {
            return "commons + 普通会员用户";
        }
    }
}
