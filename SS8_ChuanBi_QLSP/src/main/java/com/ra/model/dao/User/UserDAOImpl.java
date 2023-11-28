package com.ra.model.dao.User;

import com.ra.model.entity.User;
import com.ra.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> findAll() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return users;
    }

    @Override
    public List<User> findByName(String Name) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From user WHERE Id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return user;
    }

    @Override
    public boolean saveOrUpDate(User user, Integer id) {
        Connection connection;
        connection = ConnectionDB.openConnection();
        try {
            if (id == null) {
                PreparedStatement pstm = connection.prepareStatement("INSERT INTO user(name,email,country) VALUES (?,?,?)");
                pstm.setString(1, user.getName());
                pstm.setString(2, user.getEmail());
                pstm.setString(3, user.getCountry());
                int check = pstm.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } else {
                PreparedStatement pstm = connection.prepareStatement("UPDATE user SET name = ?, email=?, country =? WHERE  id =?");
                pstm.setString(1, user.getName());
                pstm.setString(2, user.getEmail());
                pstm.setString(3, user.getCountry());
                pstm.setInt(4, id);
                int check1 = pstm.executeUpdate();
                if (check1 > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?");
            preparedStatement.setInt(1, integer);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNewId() {
        return 0;
    }
}
