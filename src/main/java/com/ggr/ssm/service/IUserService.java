package com.ggr.ssm.service;

import com.ggr.ssm.bean.User;

import java.util.List;

/**
 * Created by GuiRunning on 2017/7/25.
 */
public interface IUserService {
    public List<User> findAllUsers();
    public int register(User user);
}
