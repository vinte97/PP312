package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    public User getUserByUd(long id) {
        return userDAO.getUserByUd(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }
    public void update(User user) {
        userDAO.update(user);
    }

    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}
