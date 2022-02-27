package org.example;

import org.example.dao.impl.UserInfoDaoImpl;
import org.example.proxy.StaticProxyUserInfoDao;
import org.junit.Test;

/**
 * @className Demo02.java
 * @author zhang chuan
 * @version V1.0
 * @date 2022/02/16 14:40
 * @description 测试代理类
 */
public class Demo02 {

    /**
     * @author zhang chuan
     * @date 2022/2/16 14:40
     * @description 测试静态代理类的实现
     */
    @Test
    public void test01(){
        StaticProxyUserInfoDao staticProxy = new StaticProxyUserInfoDao(new UserInfoDaoImpl());
        staticProxy.addUser();
        staticProxy.deleteUser();
    }

}
