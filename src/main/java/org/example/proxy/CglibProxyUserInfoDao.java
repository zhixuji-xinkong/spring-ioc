package org.example.proxy;

import org.example.dao.impl.UserInfoDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhang chuan
 * @version V1.0
 * @className CglibProxyUserInfoDao.java
 * @date 2022/02/16 14:57
 * @description Cglib 动态代理
 */
public class CglibProxyUserInfoDao {
    public static void main(String[] args) {
        // 被代理类对象
        UserInfoDaoImpl userInfoDao = new UserInfoDaoImpl();
        // 处理类
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(UserInfoDaoImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开启事务");
                Object invoke = method.invoke(userInfoDao, objects);
                System.out.println("结束事务");
                return invoke;
            }
        });

        // 创建代理对象
        UserInfoDaoImpl cglibProxy = (UserInfoDaoImpl)enhancer.create();
        cglibProxy.addUser();
        userInfoDao.deleteUser();
    }
}
