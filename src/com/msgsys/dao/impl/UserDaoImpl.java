package com.msgsys.dao.impl;

import com.msgsys.dao.BaseDao;
import com.msgsys.dao.UserDao;
import com.msgsys.entity.User;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 15:47 2020/11/26
 * 描述：
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    public int insert(User user) {
        String sql = "insert into t_user (username,password,email)values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    public int update(User user) {
        String sql = "update t_user set username = ?,password = ?,email = ? where id = ?";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
    }

    public int delete(Integer id) {
        String sql = "delete from t_user where id = ?";
        return update(sql,id);
    }

    public List<User> querAll() {
        String sql="select * from t_user";
        return queryForList(User.class,sql);
    }

    public User queryUserById(Integer id) {
        String sql="select * from t_user where id=?";
        return queryForOne(User.class,sql,id);
    }

    public User queryUserByNameAndPassword(User user) {
        String sql="select * from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql,user.getUsername(),user.getPassword());
    }
}
