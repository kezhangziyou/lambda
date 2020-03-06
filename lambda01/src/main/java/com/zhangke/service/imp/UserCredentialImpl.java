package com.zhangke.service.imp;


import com.zhangke.service.IUserCredential;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: com.zhangke.int UserCredentialImpl
 * <p>TODO</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
public class UserCredentialImpl implements IUserCredential {
    @Override
    public String verifyUser(String username) {
        if ("admin".equals(username)) {
            return "系统管理员";
        } else if("manager".equals(username)) {
            return "用户管理员";
        }
        return "普通会员";
    }
}
