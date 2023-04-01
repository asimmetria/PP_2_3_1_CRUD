package org.example.services;

import org.example.dao.UserDAO;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {
    private final UserDAO userDAO;

    @Autowired
    public UsersService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> index() {
        return userDAO.index();
    }

    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
