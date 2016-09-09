package org.helloz.jpaDemo.service;

import org.helloz.jpaDemo.model.User;

/**
 * Created by helloz on 2016/9/9.
 */
public interface UserService {
    User findById(Integer id);

    User addUser(String account, String pwd);

    User find(String account);
}
