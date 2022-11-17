package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUd(long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(User updatedUser, long id) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
