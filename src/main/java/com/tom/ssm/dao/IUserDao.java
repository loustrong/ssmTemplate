package com.tom.ssm.dao;

import com.tom.ssm.model.User;

/**
 * @descriptions: IUserDao
 * @author: Tom
 * @date: 2021/2/3 上午 11:59
 * @version: 1.0
 */
public interface IUserDao {

    User selectUser(long id);

}