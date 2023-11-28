package com.ra.model.service.Product;

import com.ra.model.dao.Product.ProductDAO;
import com.ra.model.dao.Product.ProductDAOImpl;
import com.ra.model.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Product product, Integer integer) {
        return productDAO.saveOrUpDate(product, integer);
    }

    @Override
    public Product findById(Integer integer) {
        return productDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        productDAO.delete(integer);
    }

    @Override
    public int getNewId() {
        return 0;
    }

    @Override
    public List<Product> finByName(String name) {
        return productDAO.findByName(name);
    }
}
