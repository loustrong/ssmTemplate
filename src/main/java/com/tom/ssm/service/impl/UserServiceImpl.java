package com.tom.ssm.service.impl;

import com.tom.ssm.dao.IUserDao;
import com.tom.ssm.model.User;
import com.tom.ssm.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @descriptions: UserServiceImpl
 * @author: Tom
 * @date: 2021/2/3 下午 12:03
 * @version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
