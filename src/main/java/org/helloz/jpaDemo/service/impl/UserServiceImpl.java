package org.helloz.jpaDemo.service.impl;

import org.helloz.jpaDemo.model.User;
import org.helloz.jpaDemo.repository.UserRepository;
import org.helloz.jpaDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by helloz on 2016/9/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(String account, String pwd) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(pwd);
        user.setCreateAt(new Date());

        return userRepository.save(user);
    }

    @Override
    public User find(String account) {
        return userRepository.findByAccount(account);
    }

}
