package com.kata.mvc.springbootmvc.service;

import com.kata.mvc.springbootmvc.repository.UserRepository;
import com.kata.mvc.springbootmvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> getUser = userRepository.findById(id);
        return getUser.orElse(null);
    }
    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    @Transactional
    public void updateUser(Long id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }
}
