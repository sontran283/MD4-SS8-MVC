package com.ra.controller;

import com.ra.model.entity.Product;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showProduct(request, response);
        } else {
            switch (action) {
                case "add":
                    response.sendRedirect("views/add_product.jsp");
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    Product product = productService.findById(idEdit);
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("views/edit_student.jsp").forward(request, response);
                    break;
                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    productService.delete(idDelete);
                    showProduct(request, response);
                    break;
                default:
                    showProduct(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productService.findAll();
        request.setAttribute("list_product", list);
        request.getRequestDispatcher("views/product.jsp").forward(request, response);
    }
}