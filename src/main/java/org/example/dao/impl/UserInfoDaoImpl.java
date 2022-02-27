package org.example.dao.impl;

import org.example.dao.UserInfoDao;
import org.springframework.stereotype.Component;

@Component("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

    private String uName;

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public void addUser() {
        System.out.println("添加用户：" + uName);
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户：" + uName);
    }
}
