package com.ra.service;

import com.ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Product 1", 20.0, "Description 1", "Manufacturer 1"));
        products.add(new Product(2, "Product 2", 30.0, "Description 2", "Manufacturer 2"));
        products.add(new Product(3, "Product 3", 40.0, "Description 3", "Manufacturer 3"));
        products.add(new Product(4, "Product 4", 50.0, "Description 4", "Manufacturer 4"));
        products.add(new Product(5, "Product 5", 60.0, "Description 5", "Manufacturer 5"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> searchProductsByName(String productName) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(productName)) {
                result.add(product);
            }
        }
        return result;
    }
}
