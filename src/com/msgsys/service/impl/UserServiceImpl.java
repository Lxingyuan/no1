package com.msgsys.service.impl;

import com.msgsys.dao.UserDao;
import com.msgsys.dao.impl.UserDaoImpl;
import com.msgsys.entity.User;
import com.msgsys.service.UserService;

/**
 * 作者：林星源
 * 日期: 18:22 2020/11/26
 * 描述：
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public int register(User user) {
        return userDao.insert(user);
    }

    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }
}
