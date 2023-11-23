package com.ra.controller;

import com.ra.model.Product;
import com.ra.service.IProductService;
import com.ra.service.ProductServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                showProductList(req, resp);
                break;
            case "create":
                showAddProductForm(req, resp);
                break;
            case "edit":
                showEditProductForm(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "view":
                viewProduct(req, resp);
                break;
            case "search":
                searchProduct(req, resp);
                break;
            default:
                showProductList(req, resp);
        }
    }

    private void showProductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("customer/list.jsp").forward(req, resp);
    }

    private void showAddProductForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            String manufacturer = req.getParameter("manufacturer");

            Product newProduct = new Product(id, name, price, description, manufacturer);
            productService.addProduct(newProduct);
        } catch (NumberFormatException e) {
            System.out.println("no");
        }
        resp.sendRedirect("customer/create.jsp");
    }

    private void showEditProductForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            // lay ve id tren url bang cach khai bao
            String productCode = req.getParameter("id");
            // khai bao doi tuong
            Product product = productService.getProductById(Integer.parseInt(productCode));
            // mang du lieu di
            req.setAttribute("product", product);
            req.getRequestDispatcher("customer/edit.jsp").forward(req, resp);

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            String manufacturer = req.getParameter("manufacturer");

            Product product1 = productService.getProductById(Integer.parseInt(productCode));
            product1.setId(id);
            product1.setName(name);
            product1.setDescription(description);
            product1.setPrice(price);
            product1.setManufacturer(manufacturer);

            Product updatedProduct = new Product(id, name, price, description, manufacturer);
            productService.updateProduct(id, updatedProduct);
        } catch (NumberFormatException e) {
            System.out.println("no");
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        showProductList(req, resp);
    }

    private void viewProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProductById(id);

        req.setAttribute("product", product);
        req.getRequestDispatcher("customer/view.jsp").forward(req, resp);
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        List<Product> searchResults = productService.searchProductsByName(productName);

        req.setAttribute("searchResults", searchResults);
        req.getRequestDispatcher("customer/search.jsp").forward(req, resp);
    }
}
