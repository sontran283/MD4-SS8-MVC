package com.ra.model.dao.Product;

import com.ra.model.dao.Category.CategoryDAO;
import com.ra.model.dao.Category.CategoryDAOImpl;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        List<Product> products = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL SHOW_PRODUCT}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                CategoryDAO categoryDAO = new CategoryDAOImpl();
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                product.setCategory(category);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return products;
    }

    @Override
    public List<Product> findByName(String Name) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        Product product = new Product();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL FINDBYID_PRODUCT(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                CategoryDAO categoryDAO = new CategoryDAOImpl();
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return product;
    }

    @Override
    public boolean saveOrUpDate(Product product, Integer id) {
        Connection connection;
        connection = ConnectionDB.openConnection();
        boolean check = false;
        try {
            connection.setAutoCommit(false);
            CallableStatement callableStatement;
            if (id == null) {
                callableStatement = connection.prepareCall("{CALL ADD_PRODUCT(?,?,?)}");
                callableStatement.setString(1, product.getName());
                callableStatement.setFloat(2, product.getPrice());
                callableStatement.setInt(3, product.getCategory().getCategoryId());
            } else {
                callableStatement = connection.prepareCall("{CALL UPDATE_PRODUCT(?,?,?,?)}");
                callableStatement.setInt(1, id);
                callableStatement.setString(2, product.getName());
                callableStatement.setFloat(3, product.getPrice());
                callableStatement.setInt(4, product.getCategory().getCategoryId());
            }
            int check1 = callableStatement.executeUpdate();
            if (check1 > 0) {
                check = true;
                connection.commit();
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return check;
    }


    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL DELETE_PRODUCT (?)}");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNewId() {
        return 0;
    }
}
