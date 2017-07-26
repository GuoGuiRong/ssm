package com.ggr.ssm.dao;

import com.ggr.ssm.bean.User;

import java.util.List;

/**
 * Created by GuiRunning on 2017/7/25.
 */
public interface IUserDao {
    public int saveUser(User user);
    public User findUserByName(String name);
    public List<User> findAllUsers();
    public int deleteUserById(String id);
    public int deleteUserByName(String name);
    public int updateUser(User user);
}
