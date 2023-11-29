package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.Category.CategoryService;
import com.ra.model.service.Category.CategoryServiceImpl;
import com.ra.model.service.Product.ProductService;
import com.ra.model.service.Product.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showListProduct(request, response);
        } else {
            switch (action) {
                case "add":
                    List<Category> categories = categoryService.findAll();
                    request.setAttribute("list_category", categories);
                    request.getRequestDispatcher("views/Product/addProduct.jsp").forward(request, response);
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    Product product = productService.findById(idEdit);
                    List<Category> categories1 = categoryService.findAll();
                    request.setAttribute("list_category", categories1);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("views/Product/editProduct.jsp").forward(request, response);
                    break;
                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    productService.delete(idDelete);
                    showListProduct(request, response);
                    break;
                default:
                    showListProduct(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            Product product = new Product();
            Category category = new Category();

            product.setName(request.getParameter("name"));
            product.setPrice(Float.parseFloat(request.getParameter("price")));
            category.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
            product.setCategory(category);

            if (productService.saveOrUpdate(product, null)) {
                showListProduct(request, response);
            } else {
                response.sendRedirect("views/Product/addProduct.jsp");
            }
        }else {
            editProductPost(request, response);
        }
    }

    private void editProductPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));

        Category category = categoryService.findById(Integer.valueOf(request.getParameter("categoryId")));

        Product product = new Product(idEdit, name, price, category);
        System.out.println(product);
        if (productService.saveOrUpdate(product, idEdit)) {
            showListProduct(request, response);
        } else {
            response.sendRedirect("views/Product/editProduct.jsp");
        }
    }

    public void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.findAll();
        request.setAttribute("list_product", list);
        request.getRequestDispatcher("views/Product/product.jsp").forward(request, response);
    }
}