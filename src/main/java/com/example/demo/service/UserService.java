package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @created 17.11.2022 15:43
 */
public interface UserService {

    public List<User> showAllUsers();

    public User getUserByUd(long id);

    public void save(User user);

    public void update(User updatedUser, long id);

    public void deleteUser(long id);
}
