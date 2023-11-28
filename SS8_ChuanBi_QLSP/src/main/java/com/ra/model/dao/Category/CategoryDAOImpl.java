package com.ra.model.dao.Category;

import com.ra.model.entity.Category;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
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
    public List<Category> findByName(String Name) {
        return null;
    }

    @Override
    public Category findById(Integer integer) {
        Connection c = null;
        Category category = null;
        try {
            c = ConnectionDB.openConnection();
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("SELECT * FROM category WHERE id = ?");
            ps.setInt(1, integer);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("status"));
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(c);
        }
        return category;
    }

    @Override
    public boolean saveOrUpDate(Category category, Integer id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            if (id == null) {
                String sql = "INSERT INTO category(name,status) VALUES (?,?)";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, category.getCategoryName());
                pstm.setBoolean(2, category.getCategoryStatus());
                int check = pstm.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } else {
                String sql = "UPDATE category SET name =?, status =? WHERE (id = ?)";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, category.getCategoryName());
                pstm.setBoolean(2, category.getCategoryStatus());
                pstm.setInt(3, id);
                int check = pstm.executeUpdate();
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
}
