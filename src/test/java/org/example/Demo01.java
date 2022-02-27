package org.example;

import org.example.dao.UserInfoDao;
import org.example.dao.impl.UserInfoDaoImpl;
import org.example.service.UserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {

    @Test
    public void test03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserInfoService userInfoService = ac.getBean("userInfoService", UserInfoService.class);
        userInfoService.addUser();
        userInfoService.deleteUser();
    }

    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserInfoDao userInfoDao = ac.getBean("userInfoDao", UserInfoDao.class);
        userInfoDao.addUser();
        userInfoDao.deleteUser();
    }

    @Test
    public void test01(){
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        userInfoDao.addUser();
        userInfoDao.deleteUser();
    }
}
