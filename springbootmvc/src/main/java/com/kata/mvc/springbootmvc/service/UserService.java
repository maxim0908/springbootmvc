package com.kata.mvc.springbootmvc.service;

import com.kata.mvc.springbootmvc.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(Long id);

    public void deleteUser(Long id);

    public void updateUser(Long id, User updatedUser);
}
