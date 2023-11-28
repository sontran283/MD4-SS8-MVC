package com.ra.model.dao.User;

import com.ra.model.entity.User;
import com.ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByName(String Name) {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public boolean saveOrUpDate(User user, Integer integer) {
        Connection connection;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PRO_CREATE_USER(?,?,?)}");
            callableStatement.setString(1, user.getName());
            callableStatement.setString(1, user.getEmail());
            callableStatement.setString(1, user.getCountry());
            int check = callableStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public int getNewId() {
        return 0;
    }
}
