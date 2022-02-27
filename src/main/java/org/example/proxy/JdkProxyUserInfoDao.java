package org.example.proxy;

import org.example.dao.UserInfoDao;
import org.example.dao.impl.UserInfoDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhang chuan
 * @version V1.0
 * @className JdkProxyUserInfoDao.java
 * @date 2022/02/16 14:47
 * @description jdk 动态代理
 */
public class JdkProxyUserInfoDao {
    public static void main(String[] args) {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        UserInfoDao proxy = (UserInfoDao) Proxy.newProxyInstance(
                JdkProxyUserInfoDao.class.getClassLoader(),
                userInfoDao.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        Object invoke = method.invoke(userInfoDao, args);
                        System.out.println("关闭事务");
                        return invoke;
                    }
                });
        proxy.addUser();
        userInfoDao.deleteUser();
    }
}
