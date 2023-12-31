package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.Category.CategoryService;
import com.ra.model.service.Category.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/danh_muc")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showListCategory(request, response);
        } else {
            switch (action) {
                case "add":
                    response.sendRedirect("views/Category/addCategory.jsp");
                    break;
                case "edit":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    Category category = categoryService.findById(idEdit);
                    request.setAttribute("category", category);
                    request.getRequestDispatcher("views/Category/editCategory.jsp").forward(request, response);
                    break;
                case "delete":
                    int idDelete = Integer.parseInt(request.getParameter("id"));
                    categoryService.delete(idDelete);
                    showListCategory(request, response);
                    break;
                default:
                    showListCategory(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            Category category = new Category();
            category.setCategoryName(request.getParameter("categoryName"));
            category.setCategoryStatus(Boolean.parseBoolean(request.getParameter("categoryStatus")));
            if (categoryService.saveOrUpdate(category, null)) {
                showListCategory(request, response);
            } else {
                response.sendRedirect("views/Category/addCategory.jsp?err");
            }
        }
        if (action.equals("edit")) {
            editCategoryPost(request, response);
        }
    }

    private void editCategoryPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idEdit = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("categoryName");
        boolean status = Boolean.parseBoolean(request.getParameter("categoryStatus"));
        int p_quantity = Integer.parseInt(request.getParameter("p_quantity"));
        Category category = new Category(idEdit, name, status, p_quantity);
        if (categoryService.saveOrUpdate(category, idEdit)) {
            showListCategory(request, response);
        } else {
            response.sendRedirect("views/Category/addCategory.jsp");
        }
    }

    public void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/Category/category.jsp").forward(request, response);
    }
}