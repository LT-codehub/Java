package com.tao.service;

import com.tao.entry.User;

import java.util.List;

/**
 * @author LTMAX
 * @date 2023/10/21 12:51
 * @description: TODO
 */
public interface UserService {
    List<User> findAll();
    User findById(int id);
    void insert(User user);
    void update(User user);
    void delete(int id);
}
