package org.example.proxy;

import org.example.dao.UserInfoDao;
import org.example.dao.impl.UserInfoDaoImpl;

/**
 * @className StaticProxyUserInfoDao.java
 * @author zhang chuan
 * @version V1.0
 * @date 2022/02/16 14:36
 * @description 静态代理
 */
public class StaticProxyUserInfoDao implements UserInfoDao {

    UserInfoDaoImpl userInfoDao;

    public StaticProxyUserInfoDao(UserInfoDaoImpl userInfoDao){
        this.userInfoDao = userInfoDao;
    }

    @Override
    public void addUser() {
        System.out.println("开启事务");
        userInfoDao.addUser();
        System.out.println("提交事务");
    }

    @Override
    public void deleteUser() {
        System.out.println("开启事务");
        userInfoDao.deleteUser();
        System.out.println("提交事务");
    }
}
