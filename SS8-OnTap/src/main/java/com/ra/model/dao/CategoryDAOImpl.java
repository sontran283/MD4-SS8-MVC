package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDao {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public boolean saveOrUpdate(Category category, Integer id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            if (id == null) {
                String sql = "INSERT INTO category (name,status) VALUES(?,?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, category.getCategoryName());
                statement.setBoolean(2, category.getCategoryStatus());
                int check = statement.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } else {
                String sqlUpdate = "UPDATE category SET name = ? ,status = ? WHERE id =  ?";
                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1, category.getCategoryName());
                statement.setBoolean(2, category.getCategoryStatus());
                statement.setInt(3, id);
                int check = statement.executeUpdate();
                if (check > 0) {
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
    public Category findById(Integer integer) {
        List<Category> categories = findAll();
        for (Category category : categories) {
            if (category.getCategoryId() == integer) {
                return category;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            String sql = "DELETE FROM category WHERE (id = ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, integer);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public int getNewId() {
        return 0;
    }

    @Override
    public List<Category> finByName(String name) {
        return null;
    }
}
