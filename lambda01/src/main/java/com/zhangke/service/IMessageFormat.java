package com.zhangke.service;

/**
 * 消息传输格式化转换接口
 */
@FunctionalInterface
public interface IMessageFormat {

    /**
     * 消息转换方法
     *
     * @param message 要转换的消息
     * @param format  转换的格式[xml/json..]
     * @return 返回转换后的数据
     */
    String format(String message, String format);

    /**
     * 从object继承过来的抽象方法不会报错，
     *
     * @return
     */
    @Override
    String toString();
    /**
     * 自己定义的抽象方法会报错
     */
    //boolean test();

    /**
     * 静态方法
     * 消息合法性验证方法
     *
     * @param msg 要验证的消息
     * @return 返回验证结果
     */
    static boolean verifyMessage(String msg) {
        if (msg != null) {
            return true;
        }
        return false;
    }
}
