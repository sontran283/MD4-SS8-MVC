package com.ra.service;

import com.ra.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    List<Product> searchProductsByName(String productName);
}
