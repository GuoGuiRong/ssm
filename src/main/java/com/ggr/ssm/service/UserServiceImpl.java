package com.ggr.ssm.service;

import com.ggr.ssm.bean.User;
import com.ggr.ssm.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GuiRunning on 2017/7/25.
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    public List<User> findAllUsers() {
        return iUserDao.findAllUsers();
    }
    public int register(User user) {
        return iUserDao.saveUser(user);
    }
}
