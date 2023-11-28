package com.ra.model.service.User;

import com.ra.model.dao.User.UserDAO;
import com.ra.model.dao.User.UserDAOImpl;
import com.ra.model.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(User user, Integer integer) {
        return userDAO.saveOrUpDate(user, integer);
    }

    @Override
    public User findById(Integer integer) {
        return userDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        userDAO.delete(integer);
    }

    @Override
    public int getNewId() {
        return 0;
    }

    @Override
    public List<User> finByName(String name) {
        return userDAO.findByName(name);
    }
}
