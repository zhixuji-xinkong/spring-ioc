package org.example.service.impl;

import org.example.dao.UserInfoDao;
import org.example.dao.impl.UserInfoDaoImpl;
import org.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    // 1 原始方式
//    UserInfoDao userInfoDao = new UserInfoDaoImpl();

//    private UserInfoDao userInfoDao;

    // 2、DI注入1，setter
//    public void setUserInfoDao(UserInfoDao userInfoDao) {
//        this.userInfoDao = userInfoDao;
//    }

    // 2、DI注入2：构造器
//    public UserInfoServiceImpl(UserInfoDao userInfoDao){
//        this.userInfoDao = userInfoDao;
//    }

    // 3、注解注入1--名称注入：@Resource(name = "userInfoDao")
//    @Resource(name = "userInfoDao")
//    private UserInfoDao userInfoDao;

    // 4、注解注入2--类型自动注入：@Autowired
//    @Autowired
//    private UserInfoDao userInfoDao;

    // 5、注解注入3--类型自动注入,区别指定对象：@Autowired @Qualifier(value = "userInfoDao2")
    @Autowired
    @Qualifier(value = "userInfoDao")
    private UserInfoDao userInfoDao;

    @Override
    public void addUser() {
        userInfoDao.addUser();
    }

    @Override
    public void deleteUser() {
        userInfoDao.deleteUser();
    }

}
